package com.inttegro.operatingpolicies;

public record OperatingPolicySource(Type type, String id, Long version) {
    public enum Type { inline, template }
}
