package com.inttegro.apps;

import java.time.OffsetDateTime;

/** Current availability of one commerce capability. */
public class AppCapability {
    public String status;
    public OffsetDateTime statusChangedAt;
    public String statusReason;
    public AppCapabilityRequirements requirements;
}
