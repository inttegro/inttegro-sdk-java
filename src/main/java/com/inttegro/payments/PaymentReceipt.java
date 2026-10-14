package com.inttegro.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inttegro.orders.OrderDocumentDeliverySummary;

/** Receipt issued for a paid order payment. */
public class PaymentReceipt {
    public String number;
    public PaymentReceiptFormat format;
    @JsonProperty("delivery_summary") public OrderDocumentDeliverySummary deliverySummary;
}
