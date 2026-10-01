package com.inttegro.products;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Amount;
import com.inttegro.prices.CustomerSelectedAmount;
import com.inttegro.prices.PriceType;

public class ProductDefaultUnitPrice {
    public String id;
    @JsonProperty("product_id")
    public String productId;
    public String label;
    public String about;
    public PriceType type;
    public Amount nominal;
    @JsonProperty("fixed_amount") public Amount fixedAmount;
    @JsonProperty("customer_selected_amount") public CustomerSelectedAmount customerSelectedAmount;
    @JsonProperty("created_at")
    public OffsetDateTime createdAt;
    @JsonProperty("updated_at")
    public OffsetDateTime updatedAt;
    @JsonProperty("archived_at")
    public OffsetDateTime archivedAt;
}
