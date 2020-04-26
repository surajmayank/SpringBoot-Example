package com.example.EurkeServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurkeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurkeServerApplication.class, args);
	}

}
