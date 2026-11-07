package com.inttegro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/** A non-empty public-property selection for one response resource. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PropertySelection {
    @JsonProperty("pick")
    public final List<String> pick;

    @JsonProperty("omit")
    public final List<String> omit;

    private PropertySelection(List<String> pick, List<String> omit) {
        this.pick = pick;
        this.omit = omit;
    }

    /** Includes only the named paths and the ancestors needed to contain them. */
    public static PropertySelection pick(String... propertyPaths) {
        return new PropertySelection(paths("pick", propertyPaths), null);
    }

    /** Excludes the named paths and all of their descendants. */
    public static PropertySelection omit(String... propertyPaths) {
        return new PropertySelection(null, paths("omit", propertyPaths));
    }

    private static List<String> paths(String mode, String[] propertyPaths) {
        if (propertyPaths == null || propertyPaths.length == 0) {
            throw new IllegalArgumentException(mode + " must contain at least one property path");
        }
        if (Arrays.stream(propertyPaths).anyMatch(path -> path == null || path.isBlank())) {
            throw new IllegalArgumentException(mode + " property paths must not be blank");
        }
        return List.copyOf(Arrays.asList(propertyPaths));
    }
}
