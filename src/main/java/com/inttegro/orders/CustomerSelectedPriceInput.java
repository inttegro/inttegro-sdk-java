package com.inttegro.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.AmountParams;

/** Couples a saved customer-selected price with one concrete unit amount. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerSelectedPriceInput {
    @JsonProperty("price_id")
    public String priceId;
    @JsonProperty("selected_amount")
    public AmountParams selectedAmount;

    public static Builder builder() { return new Builder(); }

    public void validate() {
        if (priceId == null || priceId.isBlank() || selectedAmount == null) {
            throw new IllegalArgumentException("customer-selected price requires price_id and selected_amount");
        }
    }

    public static class Builder {
        private final CustomerSelectedPriceInput input = new CustomerSelectedPriceInput();
        public Builder priceId(String priceId) { input.priceId = priceId; return this; }
        public Builder selectedAmount(AmountParams amount) { input.selectedAmount = amount; return this; }
        public CustomerSelectedPriceInput build() { input.validate(); return input; }
    }
}
