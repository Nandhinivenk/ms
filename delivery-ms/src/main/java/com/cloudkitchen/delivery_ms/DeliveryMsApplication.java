package com.cloudkitchen.delivery_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloudkitchen.delivery_ms.external")
public class DeliveryMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeliveryMsApplication.class, args);
	}
}
