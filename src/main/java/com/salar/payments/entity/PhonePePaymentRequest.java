package com.salar.payments.entity;

import lombok.*;



public class PhonePePaymentRequest {
    public String merchantTransactionId;
    public String merchantUserId;
    public Long amount; // in paise
    public String redirectUrl;
    public String redirectMode; // "POST" or "REDIRECT"
    public String callbackUrl;
    public String mobileNumber;



    public PhonePePaymentRequest(String merchantTransactionId, String merchantUserId, Long amount, String redirectUrl, String redirectMode, String callbackUrl, String mobileNumber) {
        this.merchantTransactionId = merchantTransactionId;
        this.merchantUserId = merchantUserId;
        this.amount = amount;
        this.redirectUrl = redirectUrl;
        this.redirectMode = redirectMode;
        this.callbackUrl = callbackUrl;
        this.mobileNumber = mobileNumber;
    }
    public PhonePePaymentRequest() {
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectMode() {
        return redirectMode;
    }

    public void setRedirectMode(String redirectMode) {
        this.redirectMode = redirectMode;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }






}

