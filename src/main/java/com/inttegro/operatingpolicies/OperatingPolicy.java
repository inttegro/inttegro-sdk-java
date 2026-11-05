package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record OperatingPolicy(
        String id,
        long version,
        @JsonProperty("active_version") long activeVersion,
        String name,
        String description,
        OperatingPolicyCapabilities capabilities,
        @JsonProperty("children_policy_id") String childrenPolicyId,
        @JsonProperty("children_policy_version") long childrenPolicyVersion,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("updated_at") OffsetDateTime updatedAt,
        @JsonProperty("version_created_at") OffsetDateTime versionCreatedAt
) {}
