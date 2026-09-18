package com.inttegro.refunds;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RefundProductOrderLineItem.class, name = "product"),
        @JsonSubTypes.Type(value = RefundFeeOrderLineItem.class, name = "fee"),
        @JsonSubTypes.Type(value = RefundShippingOrderLineItem.class, name = "shipping")
})
public abstract class RefundOrderLineItem {
    public String id;
}
