package com.product.input.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.input.domain.Product;
import com.product.input.service.ConvertToCsvService;

@RestController
public class ProductInputController {
	
	@Autowired
	private ConvertToCsvService convertData;
	
	
	@GetMapping("/test")
	public String test() {
		return "working";
	}
	
	@PostMapping("/input")
	public Product inputNewProduct(@RequestBody Product inputProduct) {
		convertData.convertData(inputProduct);
		return inputProduct;
		
	}

}
