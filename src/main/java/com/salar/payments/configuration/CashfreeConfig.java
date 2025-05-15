package com.salar.payments.configuration;

import com.cashfree.pg.Cashfree;
import com.cashfree.pg.Cashfree.CFEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CashfreeConfig {

    @Value("${cashfree.client.id}")
    private String clientId;

    @Value("${cashfree.client.secret}")
    private String clientSecret;

    @Value("${cashfree.environment}")
    private String environment;

    @Bean
    public Cashfree cashfreeClient() {
        CFEnvironment cfEnv = "SANDBOX".equalsIgnoreCase(environment)
                ? CFEnvironment.SANDBOX
                : CFEnvironment.PRODUCTION;

        return new Cashfree(cfEnv, clientId, clientSecret, null, null, null);
    }
}


