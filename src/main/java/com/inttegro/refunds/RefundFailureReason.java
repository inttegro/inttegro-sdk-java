package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RefundFailureReason {
    @JsonProperty("insufficient_balance") INSUFFICIENT_BALANCE,
    @JsonProperty("original_payment_method_unavailable") ORIGINAL_PAYMENT_METHOD_UNAVAILABLE,
    @JsonProperty("original_payment_not_refundable") ORIGINAL_PAYMENT_NOT_REFUNDABLE,
    @JsonProperty("refund_not_supported") REFUND_NOT_SUPPORTED,
    @JsonProperty("amount_not_supported") AMOUNT_NOT_SUPPORTED,
    @JsonProperty("refund_declined") REFUND_DECLINED,
    @JsonProperty("refund_not_permitted") REFUND_NOT_PERMITTED,
    @JsonProperty("temporarily_unavailable") TEMPORARILY_UNAVAILABLE,
    @JsonProperty("unknown") UNKNOWN
}
