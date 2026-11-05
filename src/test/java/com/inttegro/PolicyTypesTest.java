package com.inttegro;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inttegro.apps.CreateAppParams;
import com.inttegro.operatingpolicies.OperatingPolicyCapabilitiesInput;
import com.inttegro.operatingpolicies.OperatingPolicySelection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PolicyTypesTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void appOperatingPolicySelectionsUseThePublicWireShape() {
        CreateAppParams named = CreateAppParams.builder()
                .name("Child")
                .operatingPolicy(OperatingPolicySelection.byId("op_123"))
                .build();
        JsonNode namedJson = mapper.valueToTree(named);
        assertEquals("op_123", namedJson.at("/operating_policy/id").asText());

        OperatingPolicyCapabilitiesInput capabilities =
                new OperatingPolicyCapabilitiesInput(null, null, null);
        CreateAppParams inline = CreateAppParams.builder()
                .name("Child")
                .operatingPolicy(OperatingPolicySelection.inline(capabilities))
                .build();
        JsonNode inlineJson = mapper.valueToTree(inline);
        assertTrue(inlineJson.at("/operating_policy/capabilities").isObject());
    }
}
