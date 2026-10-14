package com.inttegro.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Aggregate of accepted document deliveries through one channel. */
public class OrderDocumentDeliveryChannelSummary {
    public long count;
    @JsonProperty("latest_sent_at") public OffsetDateTime latestSentAt;
}
