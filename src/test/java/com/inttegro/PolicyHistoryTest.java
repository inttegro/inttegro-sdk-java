package com.inttegro;

import com.inttegro.childrenpolicies.PageChildrenPoliciesParams;
import com.inttegro.operatingpolicies.PageOperatingPoliciesParams;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PolicyHistoryTest {
    private HttpServer server;
    private String baseUrl;
    private final List<String> childrenLookupBodies = new ArrayList<>();
    private final List<String> operatingLookupBodies = new ArrayList<>();
    private final List<String> pageBodies = new ArrayList<>();

    @BeforeEach
    void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(0), 0);
        server.setExecutor(Executors.newSingleThreadExecutor());
        baseUrl = "http://localhost:" + server.getAddress().getPort();
    }

    @AfterEach
    void stopServer() {
        if (server != null) server.stop(0);
    }

    @Test
    void lookupOmitsOrSendsExactVersionAndPagesDecodeVersions() throws Exception {
        server.createContext("/children_policies/lookup", exchange -> {
            childrenLookupBodies.add(readBody(exchange));
            respond(exchange, "{\"children_policy\":" + childrenPolicyJson(2) + "}");
        });
        server.createContext("/operating_policies/lookup", exchange -> {
            operatingLookupBodies.add(readBody(exchange));
            respond(exchange, "{\"operating_policy\":" + operatingPolicyJson(2) + "}");
        });
        server.createContext("/children_policies/page", exchange -> {
            pageBodies.add(readBody(exchange));
            respond(exchange, "{\"page\":{\"number\":0,\"size\":20,\"count\":1,\"total\":2,\"has_more\":true,\"versions\":[" + childrenPolicyJson(2) + "]}}");
        });
        server.createContext("/operating_policies/page", exchange -> {
            pageBodies.add(readBody(exchange));
            respond(exchange, "{\"page\":{\"number\":1,\"size\":10,\"count\":1,\"total\":2,\"has_more\":false,\"versions\":[" + operatingPolicyJson(1) + "]}}");
        });
        server.start();

        Client client = new Client("sk_test_123", baseUrl, HttpClient.newHttpClient());
        assertEquals(2, client.childrenPolicies().lookup().version());
        assertEquals(2, client.childrenPolicies().lookup(2).version());
        assertEquals(2, client.operatingPolicies().lookup("op_1").version());
        assertEquals(2, client.operatingPolicies().lookup("op_1", 2).version());

        var childrenPage = client.childrenPolicies().page(PageChildrenPoliciesParams.builder().build());
        var operatingPage = client.operatingPolicies().page(PageOperatingPoliciesParams.builder()
                .operatingPolicyId("op_1")
                .number(1)
                .size(10)
                .build());

        assertEquals(List.of("{}", "{\"version\":2}"), childrenLookupBodies);
        assertEquals("op_1", new com.fasterxml.jackson.databind.ObjectMapper().readTree(operatingLookupBodies.get(0)).get("operating_policy_id").asText());
        assertFalse(operatingLookupBodies.get(0).contains("version"));
        assertEquals(2, new com.fasterxml.jackson.databind.ObjectMapper().readTree(operatingLookupBodies.get(1)).get("version").asInt());
        assertEquals("{}", pageBodies.get(0));
        assertEquals(1, childrenPage.versions.size());
        assertEquals(2, childrenPage.total);
        assertEquals(1, operatingPage.versions.get(0).version());
        assertFalse(operatingPage.hasMore);
    }

    @Test
    void lookupRejectsNonPositiveVersion() {
        Client client = new Client("sk_test_123", baseUrl, HttpClient.newHttpClient());
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> client.childrenPolicies().lookup(0));
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> client.operatingPolicies().lookup("op_1", 0));
    }

    private static String readBody(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
        return new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
    }

    private static void respond(com.sun.net.httpserver.HttpExchange exchange, String json) throws IOException {
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream output = exchange.getResponseBody()) {
            output.write(bytes);
        }
    }

    private static String childrenPolicyJson(int version) {
        return "{\"id\":\"cp_1\",\"version\":" + version + ",\"active_version\":2,\"name\":\"Default\",\"capabilities\":{},\"created_at\":\"2026-11-05T10:00:00Z\",\"updated_at\":\"2026-11-05T10:00:00Z\",\"version_created_at\":\"2026-11-05T10:00:00Z\"}";
    }

    private static String operatingPolicyJson(int version) {
        return "{\"id\":\"op_1\",\"version\":" + version + ",\"active_version\":2,\"name\":\"Retail\",\"capabilities\":{},\"children_policy_id\":\"cp_1\",\"children_policy_version\":1,\"created_at\":\"2026-11-05T10:00:00Z\",\"updated_at\":\"2026-11-05T10:00:00Z\",\"version_created_at\":\"2026-11-05T10:00:00Z\"}";
    }
}
