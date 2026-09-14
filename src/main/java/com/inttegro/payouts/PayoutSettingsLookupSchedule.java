package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Active payout schedule returned by the settings endpoint. */
public final class PayoutSettingsLookupSchedule {
    @JsonProperty("aging_spec") public PayoutSettingsLookupScheduleAgingSpec agingSpec;
    public String description;
    public String interval;
    public String name;
    @JsonProperty("schedule_on") public String scheduleOn;
    public String type;
}
