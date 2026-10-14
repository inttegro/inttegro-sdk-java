package com.inttegro.apps;

import java.time.OffsetDateTime;

/** A setup item that must be completed before a capability can be enabled. */
public class AppCapabilityRequirement {
    public String code;
    public String description;
    public OffsetDateTime dueAt;
}
