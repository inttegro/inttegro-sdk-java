package com.inttegro.childrenpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record ChildrenPolicy(
        String id,
        long version,
        @JsonProperty("active_version") long activeVersion,
        String name,
        String description,
        ChildrenPolicyCapabilities capabilities,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("updated_at") OffsetDateTime updatedAt,
        @JsonProperty("version_created_at") OffsetDateTime versionCreatedAt
) {}
