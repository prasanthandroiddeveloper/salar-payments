package com.salar.payments.Controller;

import com.salar.payments.Service.PaymentService;
import com.salar.payments.Service.PhonePeService;
import com.salar.payments.entity.PhonePePaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PhonePeService phonePeService;

    @PostMapping("/create-order")
    public String createOrder() {
        return paymentService.createOrder();
    }

    @PostMapping("/initiate")
    public String initiatePayment(@RequestBody PhonePePaymentRequest request) {
        try {
            return phonePeService.initiateTransaction(request);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

