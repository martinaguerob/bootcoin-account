package com.nttdata.bootcoinaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BootcoinAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcoinAccountApplication.class, args);
	}

}
