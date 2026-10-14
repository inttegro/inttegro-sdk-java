package com.inttegro.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Requirements that currently prevent a capability from being enabled. */
public class AppCapabilityRequirements {
    @JsonProperty("currently_due")
    public List<AppCapabilityRequirement> currentlyDue;
}
