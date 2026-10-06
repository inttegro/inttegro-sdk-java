package com.inttegro.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Receipt issued for a paid order payment. */
public class PaymentReceipt {
    public String number;
    public PaymentReceiptFormat format;
    @JsonProperty("delivery_summary") public Map<String, Object> deliverySummary;
}
