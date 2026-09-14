package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RefundOfflineSettlement.class, name = "offline"),
        @JsonSubTypes.Type(value = RefundPaymentMethodSettlement.class, name = "payment_method")
})
public abstract class RefundSettlement {}
