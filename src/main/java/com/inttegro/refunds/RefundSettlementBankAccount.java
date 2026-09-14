package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RefundSettlementBankAccount {
    public String type;
    @JsonProperty("ghana_bank_account") public RefundSettlementGhanaBankAccount ghanaBankAccount;
}
