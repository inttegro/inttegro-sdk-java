package com.inttegro.payouts;

/** Caller-safe information about a terminal payout failure. */
public class PayoutFailure {
    public String detail;
    public PayoutFailureReason reason;
    public boolean retryable;
}
