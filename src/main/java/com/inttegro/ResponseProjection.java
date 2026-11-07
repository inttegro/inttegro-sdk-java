package com.inttegro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Typed public-property selections keyed by response resource name. */
public final class ResponseProjection {
    private final Map<String, PropertySelection> selections = new LinkedHashMap<>();

    public ResponseProjection() {}

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ResponseProjection(Map<String, PropertySelection> selections) {
        if (selections != null) {
            selections.forEach(this::select);
        }
    }

    /** Adds or replaces the selection for one named response resource. */
    public ResponseProjection select(String resource, PropertySelection selection) {
        if (resource == null || resource.isBlank()) {
            throw new IllegalArgumentException("response resource name must not be blank");
        }
        if (selection == null) {
            throw new IllegalArgumentException("property selection must not be null");
        }
        selections.put(resource, selection);
        return this;
    }

    @JsonValue
    public Map<String, PropertySelection> values() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(selections));
    }
}
