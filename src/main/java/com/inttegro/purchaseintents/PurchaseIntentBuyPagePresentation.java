package com.inttegro.purchaseintents;

/** Presentation settings for the hosted Buy page. */
public class PurchaseIntentBuyPagePresentation {
    public PurchaseIntentBuyPageText text;

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final PurchaseIntentBuyPagePresentation value = new PurchaseIntentBuyPagePresentation();
        public Builder text(PurchaseIntentBuyPageText text) { value.text = text; return this; }
        public PurchaseIntentBuyPagePresentation build() { return value; }
    }
}
