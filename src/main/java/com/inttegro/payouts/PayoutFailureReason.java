package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Stable, caller-safe reasons that a payout failed. */
public enum PayoutFailureReason {
    @JsonProperty("provider_declined") PROVIDER_DECLINED,
    @JsonProperty("delivery_failed") DELIVERY_FAILED,
    @JsonProperty("temporarily_unavailable") TEMPORARILY_UNAVAILABLE,
    @JsonProperty("unknown") UNKNOWN
}
