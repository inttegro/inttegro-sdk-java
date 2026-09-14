package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RefundSettlementMobileMoneyPaymentMethod extends RefundSettlementPaymentMethod {
    @JsonProperty("mobile_money") public RefundSettlementMobileMoney mobileMoney;
}
