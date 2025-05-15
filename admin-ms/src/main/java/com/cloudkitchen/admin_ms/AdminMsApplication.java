package com.cloudkitchen.admin_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloudkitchen.admin_ms.client")
public class AdminMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminMsApplication.class, args);
	}
}
