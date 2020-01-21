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

@RestController
public class ProductInputController {
	
	@Autowired
	private ConvertToCsvService convertData;
	
	
	@GetMapping("/test")
	public String test() {
		return "working";
	}
	
	@PostMapping("/input")
	public ResponseEntity<List<Product>> inputNewProduct(@RequestBody List<Product> inputProduct) {
		convertData.convertData(inputProduct);
		return new ResponseEntity<List<Product>>(inputProduct, HttpStatus.OK);
		
	}

}
