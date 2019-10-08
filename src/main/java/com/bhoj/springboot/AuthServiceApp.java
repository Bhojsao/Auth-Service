package com.bhoj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * AuthServiceApp class
 * 
 * @author Bhoj Sao
 *
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = { "com.bhoj.springboot" })
public class AuthServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApp.class, args);
	}

}
