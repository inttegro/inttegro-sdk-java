package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A page of immutable operating-policy versions, newest first. */
public final class OperatingPolicyPage {
    public int number;
    public int size;
    public int count;
    public long total;
    @JsonProperty("has_more")
    public boolean hasMore;
    public List<OperatingPolicy> versions;
}
