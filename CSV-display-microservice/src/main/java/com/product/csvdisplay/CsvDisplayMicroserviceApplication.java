package com.product.csvdisplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CsvDisplayMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvDisplayMicroserviceApplication.class, args);
	}

}
