package com.inttegro.childrenpolicies;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A page of immutable children-policy versions, newest first. */
public final class ChildrenPolicyPage {
    public int number;
    public int size;
    public int count;
    public long total;
    @JsonProperty("has_more")
    public boolean hasMore;
    public List<ChildrenPolicy> versions;
}
