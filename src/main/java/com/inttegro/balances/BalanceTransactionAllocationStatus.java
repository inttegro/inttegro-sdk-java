package com.inttegro.balances;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Caller-visible allocation state; internal workflow states are collapsed. */
public enum BalanceTransactionAllocationStatus {
    @JsonProperty("pending")
    PENDING,
    @JsonProperty("completed")
    COMPLETED
}
