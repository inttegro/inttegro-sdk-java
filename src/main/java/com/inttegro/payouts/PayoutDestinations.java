package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Supported currency-to-financial-account payout assignments. */
public final class PayoutDestinations {
    /** Financial account that receives Ghana cedi payouts. */
    @JsonProperty("ghs") public String ghs;

    public PayoutDestinations() {}

    public static PayoutDestinations ghs(String financialAccountId) {
        PayoutDestinations destinations = new PayoutDestinations();
        destinations.ghs = financialAccountId;
        return destinations;
    }
}
