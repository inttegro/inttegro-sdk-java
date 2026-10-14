package com.inttegro.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Bounded aggregate of accepted sends for one generated order document. */
public class OrderDocumentDeliverySummary {
    public OrderDocumentDeliveryChannels channels;
    @JsonProperty("latest_sent_at") public OffsetDateTime latestSentAt;
    @JsonProperty("total_count") public long totalCount;
}
