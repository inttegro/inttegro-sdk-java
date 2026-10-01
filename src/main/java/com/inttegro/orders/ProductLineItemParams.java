package com.inttegro.orders;

import com.inttegro.CustomData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.prices.PriceParams;
import com.inttegro.products.ProductType;
import java.util.Map;

/** Product line-item fields supplied in an order request. */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductLineItemParams {
    public String id;
    @JsonProperty("product_id") public String productId;
    public ProductType type;
    public String name;
    public String about;
    public Long quantity;
    public PriceParams price;
    @JsonProperty("price_id") public String priceId;
    @JsonProperty("customer_selected_price") public CustomerSelectedPriceInput customerSelectedPrice;
    public String reference;
    @JsonProperty("tax_code") public String taxCode;
    @JsonProperty("custom_data") public CustomData customData;

    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final ProductLineItemParams item = new ProductLineItemParams();
        public Builder id(String id) { item.id = id; return this; }
	public Builder productId(String productId) { item.productId = productId; return this; }
        public Builder type(ProductType type) { item.type = type; return this; }
        public Builder name(String name) { item.name = name; return this; }
        public Builder about(String about) { item.about = about; return this; }
        public Builder quantity(long quantity) { item.quantity = quantity; return this; }
        public Builder price(PriceParams price) { item.price = price; return this; }
        public Builder priceId(String priceId) { item.priceId = priceId; return this; }
        public Builder customerSelectedPrice(CustomerSelectedPriceInput selectedPrice) { item.customerSelectedPrice = selectedPrice; return this; }
        public Builder reference(String reference) { item.reference = reference; return this; }
        public Builder taxCode(String taxCode) { item.taxCode = taxCode; return this; }
        public Builder customData(CustomData customData) { item.customData = customData; return this; }
        public ProductLineItemParams build() { item.validate(); return item; }
    }

    public void validate() {
        if (customerSelectedPrice == null) {
            return;
        }
        customerSelectedPrice.validate();
        boolean catalogProduct = productId != null && !productId.isBlank() && quantity != null && quantity > 0;
        boolean mixedPriceChoice = price != null || priceId != null;
        boolean inlineFields = id != null || type != null || name != null || about != null ||
                reference != null || taxCode != null || customData != null;
        if (!catalogProduct || mixedPriceChoice || inlineFields) {
            throw new IllegalArgumentException("customer_selected_price is valid only for a catalog product and cannot be combined with price or price_id");
        }
    }
}
