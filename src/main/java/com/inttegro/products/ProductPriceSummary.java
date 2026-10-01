package com.inttegro.products;

import com.inttegro.money.Amount;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.prices.CustomerSelectedAmount;
import com.inttegro.prices.PriceType;

public class ProductPriceSummary {
    public String id;
    public boolean active;
    public String label;
    public PriceType type;
    public Amount nominal;
    @JsonProperty("fixed_amount") public Amount fixedAmount;
    @JsonProperty("customer_selected_amount") public CustomerSelectedAmount customerSelectedAmount;
}
