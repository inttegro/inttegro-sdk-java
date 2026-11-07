package com.inttegro;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Caller-controlled preferences for computing and representing a successful response. */
public final class RequestResponse {
    /** Public property selections keyed by the endpoint's response resource names. */
    @JsonProperty("projection")
    public ResponseProjection projection;

    public static Builder builder() {
        return new Builder();
    }

    /** Builds a response preference while preserving the caller's resource order. */
    public static final class Builder {
        private final ResponseProjection projection = new ResponseProjection();

        public Builder select(String resource, PropertySelection selection) {
            projection.select(resource, selection);
            return this;
        }

        public Builder projection(ResponseProjection selections) {
            if (selections == null) {
                throw new IllegalArgumentException("response projection must not be null");
            }
            selections.values().forEach(this::select);
            return this;
        }

        public RequestResponse build() {
            RequestResponse response = new RequestResponse();
            response.projection = new ResponseProjection(projection.values());
            return response;
        }
    }
}
