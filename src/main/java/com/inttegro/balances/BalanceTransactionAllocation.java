package com.inttegro.balances;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Caller-safe allocation of part of a payment balance transaction. Exactly one
 * of {@link #refund} and {@link #payout} is present, matching {@link #type}.
 */
public class BalanceTransactionAllocation {
    public String id;
    public BalanceTransactionAllocationType type;
    public BalanceTransactionAllocationStatus status;
    public BalanceTransactionAllocationUse refund;
    public BalanceTransactionAllocationUse payout;
    @JsonProperty("created_at") public OffsetDateTime createdAt;
    @JsonProperty("updated_at") public OffsetDateTime updatedAt;
    @JsonProperty("completed_at") public OffsetDateTime completedAt;
}
