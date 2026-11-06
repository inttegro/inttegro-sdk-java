package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Whether a payout contribution remains reserved, completed, or released. */
public enum PayoutBalanceTransactionStatus {
    @JsonProperty("reserved") RESERVED,
    @JsonProperty("completed") COMPLETED,
    @JsonProperty("released") RELEASED
}
