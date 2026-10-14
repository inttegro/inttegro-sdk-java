package com.inttegro.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Current availability of one commerce capability. */
public class AppCapability {
    public String status;
    @JsonProperty("status_changed_at")
    public OffsetDateTime statusChangedAt;
    @JsonProperty("status_reason")
    public String statusReason;
    public AppCapabilityRequirements requirements;
}
