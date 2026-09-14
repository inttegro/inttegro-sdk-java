package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RefundPaymentMethodSettlement extends RefundSettlement {
    @JsonProperty("payment_method") public RefundSettlementPaymentMethod paymentMethod;
}
