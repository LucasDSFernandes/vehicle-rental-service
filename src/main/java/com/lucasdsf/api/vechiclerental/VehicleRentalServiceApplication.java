package com.lucasdsf.api.vechiclerental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lucasdsf.api",
							 "com.lucasdsf.api.vehiclerental",
								"com.lucasdsf.api.vechiclerental.rest.controllers"})
@EnableFeignClients(basePackages = {"com.lucasdsf.api.vechiclerental.integration"})
public class VehicleRentalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalServiceApplication.class, args);
	}
}
