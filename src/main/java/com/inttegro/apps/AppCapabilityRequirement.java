package com.inttegro.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** A setup item that must be completed before a capability can be enabled. */
public class AppCapabilityRequirement {
    public String code;
    public String description;
    @JsonProperty("due_at")
    public OffsetDateTime dueAt;
}
