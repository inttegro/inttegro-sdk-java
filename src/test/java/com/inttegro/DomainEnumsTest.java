package com.inttegro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inttegro.files.UploadRequestStatus;
import com.inttegro.otp.InitiateOtpParams;
import com.inttegro.otp.OtpAlphabetType;
import com.inttegro.otp.OtpPurpose;
import com.inttegro.otp.OtpTransmissionStatus;
import com.inttegro.otp.OtpVerification;
import com.inttegro.otp.OtpVerificationVerdict;
import com.inttegro.products.ProductType;
import com.inttegro.refunds.RefundFailureReason;
import com.inttegro.refunds.RefundReason;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainEnumsTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void serializesDomainEnumsToTheirWireValues() throws Exception {
        assertEquals("\"digital\"", mapper.writeValueAsString(ProductType.DIGITAL));
        assertEquals("\"requested_by_customer\"", mapper.writeValueAsString(RefundReason.REQUESTED_BY_CUSTOMER));
        assertEquals("\"refund_declined\"", mapper.writeValueAsString(RefundFailureReason.REFUND_DECLINED));
        assertEquals("\"pending\"", mapper.writeValueAsString(UploadRequestStatus.PENDING));
    }

    @Test
    void deserializesWireValuesToDomainEnums() throws Exception {
        assertEquals(ProductType.DIGITAL, mapper.readValue("\"digital\"", ProductType.class));
        assertEquals(RefundReason.REQUESTED_BY_CUSTOMER, mapper.readValue("\"requested_by_customer\"", RefundReason.class));
        assertEquals(RefundFailureReason.UNKNOWN, mapper.readValue("\"unknown\"", RefundFailureReason.class));
        assertEquals(UploadRequestStatus.PENDING, mapper.readValue("\"pending\"", UploadRequestStatus.class));
    }

    @Test
    void otpRequestsAndNestedResponsesRemainStronglyTyped() throws Exception {
        var request = InitiateOtpParams.builder()
                .recipient("+233241234567")
                .purpose(OtpPurpose.SIGN_IN)
                .serviceName("Inttegro")
                .tokenAlphabetType(OtpAlphabetType.NUMERIC)
                .tokenSize(6)
                .build();
        assertEquals("numeric", mapper.valueToTree(request).get("token_alphabet_type").asText());
        assertEquals("sign_in", mapper.valueToTree(request).get("purpose").asText());

        var verification = mapper.readValue(
                "{\"transaction\":{\"id\":\"ot_test\",\"status\":\"pending_verification\",\"transmission\":{\"status\":\"submitted\"}},\"verification_attempt\":{\"id\":\"ov_test\",\"result\":{\"verdict\":\"pass\"}}}",
                OtpVerification.class);
        assertEquals(OtpTransmissionStatus.SUBMITTED, verification.transaction.transmission.status);
        assertEquals(OtpVerificationVerdict.PASS, verification.verificationAttempt.result.verdict);
    }
}
