package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Parameters for listing versions of one operating policy. */
public final class PageOperatingPoliciesParams {
    @JsonProperty("operating_policy_id")
    public String operatingPolicyId;
    public Integer number;
    public Integer size;

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private final PageOperatingPoliciesParams params = new PageOperatingPoliciesParams();

        public Builder operatingPolicyId(String operatingPolicyId) {
            params.operatingPolicyId = operatingPolicyId;
            return this;
        }

        public Builder number(Integer number) { params.number = number; return this; }
        public Builder size(Integer size) { params.size = size; return this; }

        public PageOperatingPoliciesParams build() {
            if (params.operatingPolicyId == null || params.operatingPolicyId.isBlank()) {
                throw new IllegalArgumentException("operatingPolicyId is required");
            }
            return params;
        }
    }
}
