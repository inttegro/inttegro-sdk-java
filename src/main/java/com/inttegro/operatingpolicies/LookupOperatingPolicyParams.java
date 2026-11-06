package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Parameters for retrieving the latest or an exact operating-policy version. */
public final class LookupOperatingPolicyParams {
    @JsonProperty("operating_policy_id")
    public String operatingPolicyId;
    public Long version;

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private final LookupOperatingPolicyParams params = new LookupOperatingPolicyParams();

        public Builder operatingPolicyId(String operatingPolicyId) {
            params.operatingPolicyId = operatingPolicyId;
            return this;
        }

        public Builder version(Long version) {
            if (version != null && version < 1) {
                throw new IllegalArgumentException("version must be at least 1");
            }
            params.version = version;
            return this;
        }

        public LookupOperatingPolicyParams build() {
            if (params.operatingPolicyId == null || params.operatingPolicyId.isBlank()) {
                throw new IllegalArgumentException("operatingPolicyId is required");
            }
            return params;
        }
    }
}
