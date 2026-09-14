package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RefundSettlementGhanaBankAccount {
    @JsonProperty("account_number") public String accountNumber;
    public String last4;
}
