package com.product.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProductAppDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppDiscoveryApplication.class, args);
	}

}
