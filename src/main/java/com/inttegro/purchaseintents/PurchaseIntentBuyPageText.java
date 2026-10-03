package com.inttegro.purchaseintents;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Merchant-authored copy shown on a hosted Buy page. */
public class PurchaseIntentBuyPageText {
    @JsonProperty("checkout_section_title")
    public String checkoutSectionTitle;
    @JsonProperty("amount_field_label")
    public String amountFieldLabel;
    @JsonProperty("primary_action_label")
    public String primaryActionLabel;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final PurchaseIntentBuyPageText value = new PurchaseIntentBuyPageText();
        public Builder checkoutSectionTitle(String title) { value.checkoutSectionTitle = title; return this; }
        public Builder amountFieldLabel(String label) { value.amountFieldLabel = label; return this; }
        public Builder primaryActionLabel(String label) { value.primaryActionLabel = label; return this; }
        public PurchaseIntentBuyPageText build() { return value; }
    }
}
