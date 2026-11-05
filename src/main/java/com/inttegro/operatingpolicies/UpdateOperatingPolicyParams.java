package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateOperatingPolicyParams(
        @JsonProperty("operating_policy_id") String operatingPolicyId,
        @JsonProperty("expected_version") long expectedVersion,
        String name,
        String description,
        OperatingPolicyCapabilitiesInput capabilities
) {}
