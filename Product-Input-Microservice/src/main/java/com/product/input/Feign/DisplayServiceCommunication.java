package com.product.input.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import feign.Headers;

@FeignClient(name="display-csv")
public interface DisplayServiceCommunication {
	
	@PostMapping("/upload")
	@Headers("Content-Type: multipart/form-data")
	public String getDataFromCsv(@RequestParam("file") MultipartFile file);

}
