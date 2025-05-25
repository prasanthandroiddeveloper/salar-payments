package com.salar.payments.Service;

import com.cashfree.pg.ApiException;
import com.cashfree.pg.ApiResponse;
import com.cashfree.pg.Cashfree;
import com.cashfree.pg.model.CreateOrderRequest;
import com.cashfree.pg.model.CustomerDetails;
import com.cashfree.pg.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    private Cashfree cashfree;

    public String createOrder() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId("1957");
        customerDetails.setCustomerPhone("9000968284");

        CreateOrderRequest request = new CreateOrderRequest();
        request.setOrderAmount(BigDecimal.valueOf(50.00));
        request.setOrderCurrency("INR");
        request.setCustomerDetails(customerDetails);

        try {
            ApiResponse<OrderEntity> response = cashfree.PGCreateOrder(request, null, null, null);

            return response.getData().getPaymentSessionId();
        } catch (ApiException e) {
            throw new RuntimeException("Failed to create order: " + e.getMessage(), e);
        }
    }
}
