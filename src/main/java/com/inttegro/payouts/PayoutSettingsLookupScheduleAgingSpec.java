package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Rules that determine when balance transactions become eligible for payout. */
public final class PayoutSettingsLookupScheduleAgingSpec {
    public String abide;
    @JsonProperty("public_id") public String publicId;
    public String label;
    @JsonProperty("t_plus") public String tPlus;
}
