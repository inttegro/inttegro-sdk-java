package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class RefundSettlementMobileMoney {
    public String network;
    @JsonProperty("account_number") public String accountNumber;
    public String last4;
}
