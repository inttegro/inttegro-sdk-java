package com.inttegro.otp;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OtpPurpose {
    @JsonProperty("account_creation") ACCOUNT_CREATION,
    @JsonProperty("account_recovery") ACCOUNT_RECOVERY,
    @JsonProperty("email_verification") EMAIL_VERIFICATION,
    @JsonProperty("financial_account_verification") FINANCIAL_ACCOUNT_VERIFICATION,
    @JsonProperty("password_reset") PASSWORD_RESET,
    @JsonProperty("payment_confirmation") PAYMENT_CONFIRMATION,
    @JsonProperty("payment_method_verification") PAYMENT_METHOD_VERIFICATION,
    @JsonProperty("payout_confirmation") PAYOUT_CONFIRMATION,
    @JsonProperty("phone_verification") PHONE_VERIFICATION,
    @JsonProperty("sensitive_action") SENSITIVE_ACTION,
    @JsonProperty("sign_in") SIGN_IN,
    @JsonProperty("transaction_confirmation") TRANSACTION_CONFIRMATION,
    @JsonProperty("unspecified") UNSPECIFIED
}
