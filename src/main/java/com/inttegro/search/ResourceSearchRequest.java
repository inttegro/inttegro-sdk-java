package com.inttegro.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A typed resource-local search request. */
public class ResourceSearchRequest {
    public String text;
    public List<Filter> filters;
    public List<Facet> facets;
    public Sort sort;
    @JsonProperty("page_size") public Integer pageSize;
    public String cursor;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final ResourceSearchRequest request = new ResourceSearchRequest();
        public Builder text(String text) { request.text = text; return this; }
        public Builder filters(List<Filter> filters) { request.filters = filters; return this; }
        public Builder facets(List<Facet> facets) { request.facets = facets; return this; }
        public Builder sort(Sort sort) { request.sort = sort; return this; }
        public Builder pageSize(Integer pageSize) { request.pageSize = pageSize; return this; }
        public Builder cursor(String cursor) { request.cursor = cursor; return this; }
        public ResourceSearchRequest build() { return request; }
    }

    public enum Operator {
        @JsonProperty("eq") EQ,
        @JsonProperty("in") IN
    }

    public enum SortField {
        @JsonProperty("relevance") RELEVANCE,
        @JsonProperty("updated_at") UPDATED_AT,
        @JsonProperty("published_at") PUBLISHED_AT
    }

    public enum SortDirection {
        @JsonProperty("asc") ASC,
        @JsonProperty("desc") DESC
    }

    public static class Filter {
        public String field;
        public Operator operator;
        public List<String> values;

        public static Filter of(String field, Operator operator, List<String> values) {
            Filter filter = new Filter();
            filter.field = field;
            filter.operator = operator;
            filter.values = values;
            return filter;
        }
    }

    public static class Facet {
        public String field;
        public Integer limit;

        public static Facet of(String field, Integer limit) {
            Facet facet = new Facet();
            facet.field = field;
            facet.limit = limit;
            return facet;
        }
    }

    public static class Sort {
        public SortField field;
        public SortDirection direction;

        public static Sort of(SortField field, SortDirection direction) {
            Sort sort = new Sort();
            sort.field = field;
            sort.direction = direction;
            return sort;
        }
    }
}
