package com.inttegro.chimes;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Public delivery lifecycle for a Chime. */
public final class ChimeTransmission {
    public String address;
    @JsonProperty("created_at") public OffsetDateTime createdAt;
    @JsonProperty("delivered_at") public OffsetDateTime deliveredAt;
    @JsonProperty("failed_at") public OffsetDateTime failedAt;
    @JsonProperty("initialized_at") public OffsetDateTime initializedAt;
    public ChimeTransport mechanism;
    @JsonProperty("sent_at") public OffsetDateTime sentAt;
    @JsonProperty("sent_via") public ChimeTransport sentVia;
    public String status;
    @JsonProperty("suppressed_at") public OffsetDateTime suppressedAt;
}
