package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Aging rule returned after a payout settings mutation. */
public final class PayoutSettingsMutationScheduleSpec {
    public String abide;
    public String id;
    public String label;
    @JsonProperty("t_plus") public String tPlus;
}
