package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Payout settings fields returned after a settings mutation. */
public final class PayoutSettingsMutation {
    public PayoutDestinations destinations;
    @JsonProperty("fx_enabled") public Boolean fxEnabled;
    public String id;
    public PayoutSettingsMutationSchedule schedule;
}
