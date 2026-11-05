package com.inttegro.operatingpolicies;

public record ApplicationOperatingPolicy(
        OperatingPolicyCapabilities capabilities,
        OperatingPolicySource source
) {}
