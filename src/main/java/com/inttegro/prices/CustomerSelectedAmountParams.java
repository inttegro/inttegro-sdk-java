package com.inttegro.prices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Currency;
import java.util.List;

/** Currency, range, and optional conveniences for a selected amount. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerSelectedAmountParams {
    public Currency currency;
    public Long minimum;
    public Long maximum;
    @JsonProperty("suggested_amounts")
    public List<SuggestedAmountParams> suggestedAmounts;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final CustomerSelectedAmountParams params = new CustomerSelectedAmountParams();
        public Builder currency(Currency currency) { params.currency = currency; return this; }
        public Builder minimum(long minimum) { params.minimum = minimum; return this; }
        public Builder maximum(long maximum) { params.maximum = maximum; return this; }
        public Builder suggestedAmounts(List<SuggestedAmountParams> suggestions) { params.suggestedAmounts = suggestions; return this; }
        public CustomerSelectedAmountParams build() { return params; }
    }
}
