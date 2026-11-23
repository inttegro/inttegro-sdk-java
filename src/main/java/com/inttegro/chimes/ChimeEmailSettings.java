package com.inttegro.chimes;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public final class ChimeEmailSettings {
    @JsonProperty("default_from")
    public String defaultFrom;
    @JsonProperty("allowed_from")
    public List<String> allowedFrom;
}
