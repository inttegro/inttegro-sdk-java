package com.inttegro.childrenpolicies;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChildrenPolicyCapabilities(
        Payments payments,
        Payouts payouts,
        @JsonProperty("payment_methods") PaymentMethods paymentMethods
) {
    public record AmountRange(long min, long max) {}
    public record Limits(AmountRange amount) {}
    public record BTAgingSpec(String id, @JsonProperty("t_plus") String tPlus) {}
    public record Payments(List<String> currencies, Limits limits) {}
    public record Payouts(List<Boolean> enabled, Limits limits, @JsonProperty("bt_aging_spec") List<BTAgingSpec> btAgingSpec) {}
    public record PaymentMethod(List<Boolean> enabled, @JsonProperty("confirms_use") List<Boolean> confirmsUse) {}
    public record PaymentMethods(
            @JsonProperty("mobile_money") PaymentMethod mobileMoney,
            @JsonProperty("bank_account") PaymentMethod bankAccount,
            PaymentMethod motito,
            PaymentMethod card
    ) {}
}
