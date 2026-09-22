package com.inttegro.balances;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BalanceTransactionAllocationType {
    @JsonProperty("payout")
    PAYOUT,
    @JsonProperty("refund")
    REFUND
}
