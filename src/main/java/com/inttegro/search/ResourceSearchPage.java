package com.inttegro.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Amount;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;

/** Search projections and continuation metadata returned by a resource search endpoint. */
public class ResourceSearchPage {
    @JsonProperty("resource_types") public List<ResourceType> resourceTypes;
    public ResourceSearchRequest.Sort sort;
    @JsonProperty("page_size") public Integer pageSize;
    @JsonProperty("result_count") public Integer resultCount;
    @JsonProperty("has_more") public Boolean hasMore;
    public Total total;
    @JsonProperty("resource_totals") public List<ResourceTotal> resourceTotals;
    public List<Result> results;
    public List<FacetResult> facets;
    @JsonProperty("next_cursor") public String nextCursor;
    public Freshness freshness;

    public enum ResourceType {
        @JsonProperty("customer") CUSTOMER,
        @JsonProperty("financial_account") FINANCIAL_ACCOUNT,
        @JsonProperty("order") ORDER,
        @JsonProperty("payout") PAYOUT,
        @JsonProperty("product") PRODUCT
    }

    public enum TotalRelation {
        @JsonProperty("exact") EXACT,
        @JsonProperty("lower_bound") LOWER_BOUND
    }

    public enum FreshnessState {
        @JsonProperty("current") CURRENT,
        @JsonProperty("delayed") DELAYED,
        @JsonProperty("partial") PARTIAL,
        @JsonProperty("unknown") UNKNOWN,
        @JsonProperty("unavailable") UNAVAILABLE
    }

    public static class Total {
        public Long value;
        public TotalRelation relation;
    }

    public static class ResourceTotal {
        @JsonProperty("resource_type") public ResourceType resourceType;
        public Long value;
        public TotalRelation relation;
    }

    public static class ResourceReference {
        public ResourceType type;
        public String id;
    }

    public static class Result {
        public ResourceReference resource;
        public String title;
        public String summary;
        public String status;
        @JsonProperty("customer_name") public String customerName;
        public Amount amount;
        public URI url;
        @JsonProperty("updated_at") public OffsetDateTime updatedAt;
    }

    public static class FacetBucket {
        public String value;
        public Long count;
    }

    public static class FacetResult {
        public String field;
        public List<FacetBucket> buckets;
    }

    public static class ResourceFreshness {
        @JsonProperty("resource_type") public ResourceType resourceType;
        public FreshnessState state;
        @JsonProperty("observed_at") public OffsetDateTime observedAt;
        @JsonProperty("last_indexed_at") public OffsetDateTime lastIndexedAt;
    }

    public static class Freshness {
        public FreshnessState state;
        @JsonProperty("observed_at") public OffsetDateTime observedAt;
        public List<ResourceFreshness> resources;
    }
}
