package com.inttegro.payouts;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.CustomData;
import com.inttegro.money.Amount;
import java.util.List;

/** A payout scheduled from an Inttegro balance to a destination financial account. */
public class Payout {
    public Amount amount;
    @JsonProperty("balance_transactions") public List<PayoutBalanceTransaction> balanceTransactions;
    @JsonProperty("canceled_at") public OffsetDateTime canceledAt;
    @JsonProperty("custom_data") public CustomData customData;
    @JsonProperty("destination_id") public String destinationId;
    public PayoutError error;
    @JsonProperty("execute_after") public OffsetDateTime executeAfter;
    @JsonProperty("executed_by") public String executedBy;
    @JsonProperty("expected_at") public OffsetDateTime expectedAt;
    @JsonProperty("failed_at") public OffsetDateTime failedAt;
    public String id;
    @JsonProperty("initiated_at") public OffsetDateTime initiatedAt;
    @JsonProperty("initiated_by") public String initiatedBy;
    @JsonProperty("max_amount") public Amount maxAmount;
    public String reference;
    @JsonProperty("schedule_id") public String scheduleId;
    @JsonProperty("scheduled_at") public OffsetDateTime scheduledAt;
    @JsonProperty("scheduled_by") public String scheduledBy;
    @JsonProperty("sent_at") public OffsetDateTime sentAt;
    @JsonProperty("source_id") public String sourceId;
    public PayoutStatus status;
    @JsonProperty("succeeded_at") public OffsetDateTime succeededAt;
}
