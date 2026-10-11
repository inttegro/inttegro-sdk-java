package com.inttegro.apps;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Direct placement relationship returned when a child application is created. */
public class AppRelationship {
    public String id;
    public AppRelationshipKind kind;
    public AppRelationshipParent parent;
    public AppRelationshipStatus status;
    @JsonProperty("created_at") public OffsetDateTime createdAt;
}
