package com.inttegro.childrenpolicies;

/** Optional pagination parameters for listing children-policy versions. */
public final class PageChildrenPoliciesParams {
    public Integer number;
    public Integer size;

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private final PageChildrenPoliciesParams params = new PageChildrenPoliciesParams();

        public Builder number(Integer number) { params.number = number; return this; }
        public Builder size(Integer size) { params.size = size; return this; }
        public PageChildrenPoliciesParams build() { return params; }
    }
}
