package com.kitchenflow.notification_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotificationMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationMsApplication.class, args);
	}
}
