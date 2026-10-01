package com.inttegro.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.AmountParams;
import com.inttegro.prices.CustomerSelectedAmountParams;
import com.inttegro.prices.PriceType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddProductPriceParams {
    @JsonProperty("product_id")
    public String productId;
    public String label;
    public String about;
    public PriceType type;
    @JsonProperty("fixed_amount")
    public AmountParams fixedAmount;
    @JsonProperty("customer_selected_amount")
    public CustomerSelectedAmountParams customerSelectedAmount;
    @JsonProperty("set_as_default")
    public Boolean setAsDefault;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final AddProductPriceParams params = new AddProductPriceParams();
        public Builder productId(String productId) { params.productId = productId; return this; }
        public Builder label(String label) { params.label = label; return this; }
        public Builder about(String about) { params.about = about; return this; }
        public Builder type(PriceType type) { params.type = type; return this; }
        public Builder fixedAmount(AmountParams amount) { params.fixedAmount = amount; return this; }
        public Builder customerSelectedAmount(CustomerSelectedAmountParams amount) { params.customerSelectedAmount = amount; return this; }
        public Builder setAsDefault(Boolean setAsDefault) { params.setAsDefault = setAsDefault; return this; }
        public Builder setAsDefault(boolean setAsDefault) { params.setAsDefault = setAsDefault; return this; }
        public AddProductPriceParams build() { params.validate(); return params; }
    }

    public void validate() {
        boolean hasProduct = productId != null && !productId.isBlank();
        boolean fixed = type == PriceType.FIXED_AMOUNT && fixedAmount != null && customerSelectedAmount == null;
        boolean selected = type == PriceType.CUSTOMER_SELECTED_AMOUNT && customerSelectedAmount != null && fixedAmount == null;
        if (!hasProduct || (fixed ? 1 : 0) + (selected ? 1 : 0) != 1) {
            throw new IllegalArgumentException("provide a product ID and exactly one valid price definition");
        }
    }
}
