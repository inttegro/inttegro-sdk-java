package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Amount;

public class RefundLineItem {
    public String id;
    /** @deprecated Use {@link #orderLineItem} and its {@code id}. */
    @Deprecated
    @JsonProperty("order_line_item_id") public String orderLineItemId;
    @JsonProperty("order_line_item") public RefundOrderLineItem orderLineItem;
    @JsonProperty("original_amount_paid") public Amount originalAmountPaid;
    @JsonProperty("refund_amount") public Amount refundAmount;
    public RefundReason reason;
    @JsonProperty("reason_details") public String reasonDetails;
}
