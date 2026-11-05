package com.inttegro.operatingpolicies;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OperatingPolicyCapabilitiesInput(
        Payments payments,
        Payouts payouts,
        @JsonProperty("payment_methods") PaymentMethods paymentMethods
) {
    public record AmountRange(long min, long max) {}
    public record Limits(AmountRange amount) {}
    public record BTAgingSpecReference(String id) {}
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Payments(List<String> currencies, Limits limits) {}
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Payouts(Boolean enabled, Limits limits, @JsonProperty("bt_aging_spec") BTAgingSpecReference btAgingSpec) {}
    public record PaymentMethod(boolean enabled, @JsonProperty("confirms_use") boolean confirmsUse) {}
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record PaymentMethods(
            @JsonProperty("mobile_money") PaymentMethod mobileMoney,
            @JsonProperty("bank_account") PaymentMethod bankAccount,
            PaymentMethod motito,
            PaymentMethod card
    ) {}
}
