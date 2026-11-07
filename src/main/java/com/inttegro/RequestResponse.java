package com.inttegro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Caller-controlled preferences for computing and representing a successful response. */
public final class RequestResponse {
    /** Public property selections keyed by the endpoint's response resource names. */
    @JsonProperty("projection")
    public Map<String, PropertySelection> projection;

    public static Builder builder() {
        return new Builder();
    }

    /** Builds a response preference while preserving the caller's resource order. */
    public static final class Builder {
        private final Map<String, PropertySelection> projection = new LinkedHashMap<>();

        public Builder select(String resource, PropertySelection selection) {
            if (resource == null || resource.isBlank()) {
                throw new IllegalArgumentException("response resource name must not be blank");
            }
            if (selection == null) {
                throw new IllegalArgumentException("property selection must not be null");
            }
            projection.put(resource, selection);
            return this;
        }

        public Builder projection(Map<String, PropertySelection> selections) {
            if (selections == null) {
                throw new IllegalArgumentException("response projection must not be null");
            }
            selections.forEach(this::select);
            return this;
        }

        public RequestResponse build() {
            RequestResponse response = new RequestResponse();
            response.projection = Collections.unmodifiableMap(new LinkedHashMap<>(projection));
            return response;
        }
    }
}
