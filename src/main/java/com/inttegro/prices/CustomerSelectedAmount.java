package com.inttegro.prices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Currency;
import java.util.List;

/** Persisted currency, range, and suggestions for a selected amount. */
public class CustomerSelectedAmount {
    public Currency currency;
    public Long minimum;
    public Long maximum;
    @JsonProperty("suggested_amounts")
    public List<SuggestedAmount> suggestedAmounts;
}
