package com.cloudkitchen.customer_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloudkitchen.customer_ms.client")
public class CustomerMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerMsApplication.class, args);
	}
}
