package com.cloudkitchen.fooditem_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloudkitchen.fooditem_ms.external")
public class FooditemMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(FooditemMsApplication.class, args);
	}
}
