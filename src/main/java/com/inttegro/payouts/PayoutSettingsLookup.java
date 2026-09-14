package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Complete payout settings returned by the settings endpoint. */
public final class PayoutSettingsLookup {
    public PayoutDestinations destinations;
    @JsonProperty("fx_enabled") public Boolean fxEnabled;
    public PayoutSettingsLookupSchedule schedule;
}
