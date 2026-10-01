package com.inttegro.prices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.AmountParams;

/** Parameters for creating a stored catalog price. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogPriceParams {
    @JsonProperty("product_id")
    public String productId;
    public String label;
    public String about;
    public PriceType type;
    @JsonProperty("fixed_amount")
    public AmountParams fixedAmount;
    @JsonProperty("customer_selected_amount")
    public CustomerSelectedAmountParams customerSelectedAmount;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final CatalogPriceParams params = new CatalogPriceParams();
        public Builder productId(String productId) { params.productId = productId; return this; }
        public Builder label(String label) { params.label = label; return this; }
        public Builder about(String about) { params.about = about; return this; }
        public Builder type(PriceType type) { params.type = type; return this; }
        public Builder fixedAmount(AmountParams amount) { params.fixedAmount = amount; return this; }
        public Builder customerSelectedAmount(CustomerSelectedAmountParams amount) { params.customerSelectedAmount = amount; return this; }
        public CatalogPriceParams build() { params.validate(); return params; }
    }

    public void validate() {
        boolean fixed = type == PriceType.FIXED_AMOUNT && fixedAmount != null && customerSelectedAmount == null;
        boolean selected = type == PriceType.CUSTOMER_SELECTED_AMOUNT && customerSelectedAmount != null &&
                fixedAmount == null && productId != null && !productId.isBlank();
        if ((fixed ? 1 : 0) + (selected ? 1 : 0) != 1) {
            throw new IllegalArgumentException("provide exactly one valid catalog price definition");
        }
    }
}
