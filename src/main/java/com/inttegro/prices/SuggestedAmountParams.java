package com.inttegro.prices;

import com.fasterxml.jackson.annotation.JsonInclude;

/** A convenient amount choice; suggestions do not restrict valid amounts. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuggestedAmountParams {
    public String id;
    public Long value;
    public Boolean recommended;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final SuggestedAmountParams params = new SuggestedAmountParams();
        public Builder id(String id) { params.id = id; return this; }
        public Builder value(long value) { params.value = value; return this; }
        public Builder recommended(boolean recommended) { params.recommended = recommended; return this; }
        public SuggestedAmountParams build() { return params; }
    }
}
