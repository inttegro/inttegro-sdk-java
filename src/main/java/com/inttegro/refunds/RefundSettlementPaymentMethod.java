package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RefundSettlementMobileMoneyPaymentMethod.class, name = "mobile_money"),
        @JsonSubTypes.Type(value = RefundSettlementBankAccountPaymentMethod.class, name = "bank_account")
})
public abstract class RefundSettlementPaymentMethod {
    public String id;
}
