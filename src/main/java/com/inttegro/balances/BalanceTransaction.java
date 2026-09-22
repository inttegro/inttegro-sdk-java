package com.inttegro.balances;

import java.time.OffsetDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Amount;

public class BalanceTransaction {
    public String id;
    public BalanceTransactionType type;
    @JsonProperty("payment_id") public String paymentId;
    @JsonProperty("refund_id") public String refundId;
    /** @deprecated Inspect {@link #allocations} because one transaction can fund many payouts. */
    @Deprecated
    @JsonProperty("payout_id") public String payoutId;
    @JsonProperty("order_id") public String orderId;
    public Amount amount;
    public List<BalanceTransactionAllocation> allocations;
    @JsonProperty("available_amount") public Amount availableAmount;
    @JsonProperty("pending_amount") public Amount pendingAmount;
    @JsonProperty("spent_amount") public Amount spentAmount;
    @JsonProperty("available_at") public OffsetDateTime availableAt;
    /** @deprecated Inspect {@link #allocations} for current payout participation. */
    @Deprecated
    @JsonProperty("claimed_at") public OffsetDateTime claimedAt;
    /** @deprecated Inspect completed {@link #allocations} for consumed amounts. */
    @Deprecated
    @JsonProperty("paid_at") public OffsetDateTime paidAt;
    @JsonProperty("created_at") public OffsetDateTime createdAt;
    @JsonProperty("payout_configuration") public PayoutConfiguration payoutConfiguration;

    public String sourceId() {
        if (type == BalanceTransactionType.PAYMENT && paymentId != null && !paymentId.isBlank() && refundId == null) {
            return paymentId;
        }
        if (type == BalanceTransactionType.REFUND && refundId != null && !refundId.isBlank() && paymentId == null) {
            return refundId;
        }
        return null;
    }
}
