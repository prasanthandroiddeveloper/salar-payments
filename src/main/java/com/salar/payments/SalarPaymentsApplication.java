package com.salar.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SalarPaymentsApplication {

	public static void main(String[] args) {

		System.out.println("salar_payment");
		SpringApplication.run(SalarPaymentsApplication.class, args);
	}

}
