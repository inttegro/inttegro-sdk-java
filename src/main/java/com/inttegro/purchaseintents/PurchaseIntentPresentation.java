package com.inttegro.purchaseintents;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Customer-facing presentation settings for a purchase intent. */
public class PurchaseIntentPresentation {
    @JsonProperty("buy_page")
    public PurchaseIntentBuyPagePresentation buyPage;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final PurchaseIntentPresentation value = new PurchaseIntentPresentation();
        public Builder buyPage(PurchaseIntentBuyPagePresentation buyPage) { value.buyPage = buyPage; return this; }
        public PurchaseIntentPresentation build() { return value; }
    }
}
