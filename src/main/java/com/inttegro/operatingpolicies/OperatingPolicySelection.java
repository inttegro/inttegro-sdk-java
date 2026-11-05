package com.inttegro.operatingpolicies;

public sealed interface OperatingPolicySelection permits OperatingPolicySelection.ById, OperatingPolicySelection.Inline {
    record ById(String id) implements OperatingPolicySelection {}
    record Inline(OperatingPolicyCapabilitiesInput capabilities) implements OperatingPolicySelection {}

    static ById byId(String id) { return new ById(id); }
    static Inline inline(OperatingPolicyCapabilitiesInput capabilities) { return new Inline(capabilities); }
}
