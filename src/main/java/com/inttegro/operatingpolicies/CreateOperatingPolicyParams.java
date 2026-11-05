package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateOperatingPolicyParams(
        String name,
        String description,
        OperatingPolicyCapabilitiesInput capabilities
) {}
