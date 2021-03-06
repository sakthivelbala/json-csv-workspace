package com.product.input.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="${display.microservice.name}",fallback=DisplayServiceCommunicationFallback.class)
public interface DisplayServiceCommunication {
	
	@PostMapping("${display.csv.upload.rest.path}")
	public String getDataFromCsv(@RequestParam("file") byte[] file);
	
	@PostMapping("${test.rest.path}")
	public String test(@RequestParam("input") String input);

}
