package com.product.input.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.input.domain.Product;
import com.product.input.service.ConvertToCsvService;
import com.product.input.service.IsActiveDisplayService;

@RestController
public class ProductInputController {
	
	@Autowired
	private ConvertToCsvService convertData;
	
	@Autowired
	private IsActiveDisplayService isActiveDisplayService;
	
	@GetMapping("/test")
	public String test() {
		return isActiveDisplayService.testService()+"\n Product Input Service Working";
	}
	
	@PostMapping("/input")
	public ResponseEntity<String> inputNewProduct(@RequestBody List<Product> inputProduct) {
		return new ResponseEntity<String>(convertData.convertData(inputProduct), HttpStatus.OK);
		
	}

}
