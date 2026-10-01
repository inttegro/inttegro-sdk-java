package com.inttegro.prices;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Definition carried by a catalog price. */
public enum PriceType {
    @JsonProperty("fixed_amount") FIXED_AMOUNT,
    @JsonProperty("customer_selected_amount") CUSTOMER_SELECTED_AMOUNT
}
