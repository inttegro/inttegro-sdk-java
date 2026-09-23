package com.inttegro.payouts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.money.Amount;

/** A sparse view of one balance transaction's contribution to a payout. */
public class PayoutBalanceTransaction {
    /** The exact portion allocated to this payout. */
    @JsonProperty("allocated_amount") public Amount allocatedAmount;

    /** The balance transaction's original amount before allocations. */
    public Amount amount;

    /** Unique balance transaction identifier. */
    public String id;
}
