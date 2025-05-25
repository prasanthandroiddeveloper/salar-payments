package com.salar.payments.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salar.payments.entity.PhonePePaymentRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhonePeService {

    @Value("${phonepe.salt-key}")
    public String saltKey;

    @Value("${phonepe.salt-index}")
    public String saltIndex;

    @Value("${phonepe.merchant-id}")
    public String merchantId;

    @Value("${phonepe.base-url}")
    public String baseUrl;

    public String initiateTransaction(PhonePePaymentRequest req) throws Exception {
        String url = baseUrl + "/pg/v1/pay";

        Map<String, Object> payLoadMap = new HashMap<>();
        payLoadMap.put("merchantId", merchantId);
        payLoadMap.put("merchantTransactionId", req.getMerchantTransactionId());
        payLoadMap.put("merchantUserId", req.getMerchantUserId());
        payLoadMap.put("amount", req.getAmount());
        payLoadMap.put("redirectUrl", req.getRedirectUrl());
        payLoadMap.put("redirectMode", req.getRedirectMode());
        payLoadMap.put("callbackUrl", req.getCallbackUrl());

        Map<String, Object> paymentInstrument = new HashMap<>();
        paymentInstrument.put("type", "PAY_PAGE");
        payLoadMap.put("paymentInstrument", paymentInstrument);

        String payload = new ObjectMapper().writeValueAsString(payLoadMap);
        String base64Payload = Base64.getEncoder().encodeToString(payload.getBytes(StandardCharsets.UTF_8));

        String xVerify = DigestUtils.sha256Hex(base64Payload + "/pg/v1/pay" + saltKey) + "###" + saltIndex;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-VERIFY", xVerify);
        headers.set("X-MERCHANT-ID", merchantId);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("request", base64Payload);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        return response.getBody();
    }
}

