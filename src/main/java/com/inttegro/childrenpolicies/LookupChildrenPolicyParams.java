package com.inttegro.childrenpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Parameters for retrieving the latest or an exact children-policy version. */
public final class LookupChildrenPolicyParams {
    @JsonProperty("version")
    public Long version;

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private final LookupChildrenPolicyParams params = new LookupChildrenPolicyParams();

        public Builder version(Long version) {
            if (version != null && version < 1) {
                throw new IllegalArgumentException("version must be at least 1");
            }
            params.version = version;
            return this;
        }

        public LookupChildrenPolicyParams build() { return params; }
    }
}
