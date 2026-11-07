package com.inttegro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestMeta {
    @JsonProperty("idempotency_key")
    public String idempotencyKey;

    @JsonProperty("response")
    public RequestResponse response;

    public static Builder builder() { return new Builder(); }

    public static RequestMeta withIdempotencyKey(String key) {
        RequestMeta meta = new RequestMeta();
        meta.idempotencyKey = key;
        return meta;
    }

    public static class Builder {
        private final RequestMeta meta = new RequestMeta();
        public Builder idempotencyKey(String idempotencyKey) { meta.idempotencyKey = idempotencyKey; return this; }
        public Builder response(RequestResponse response) { meta.response = response; return this; }
        public RequestMeta build() { return meta; }
    }
}
