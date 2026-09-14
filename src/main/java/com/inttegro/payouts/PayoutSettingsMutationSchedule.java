package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Updated payout schedule returned after a settings mutation. */
public final class PayoutSettingsMutationSchedule {
    public String description;
    public String id;
    public String interval;
    public String name;
    @JsonProperty("schedule_on") public String scheduleOn;
    public PayoutSettingsMutationScheduleSpec spec;
    public String type;
}
