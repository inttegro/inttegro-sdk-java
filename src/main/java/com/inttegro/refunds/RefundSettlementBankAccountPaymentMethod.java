package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RefundSettlementBankAccountPaymentMethod extends RefundSettlementPaymentMethod {
    @JsonProperty("bank_account") public RefundSettlementBankAccount bankAccount;
}
