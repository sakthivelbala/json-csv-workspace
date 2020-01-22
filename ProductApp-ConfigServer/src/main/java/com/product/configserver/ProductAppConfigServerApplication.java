package com.product.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ProductAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppConfigServerApplication.class, args);
		System.setProperty("proxyHost", "proxy.cognizant.com");
		System.setProperty("proxyPort", "6050");
	}

}
