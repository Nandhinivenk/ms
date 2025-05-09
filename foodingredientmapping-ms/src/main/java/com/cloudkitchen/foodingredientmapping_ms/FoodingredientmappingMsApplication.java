package com.cloudkitchen.foodingredientmapping_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloudkitchen.foodingredientmapping_ms.external")
public class FoodingredientmappingMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodingredientmappingMsApplication.class, args);
	}
}
