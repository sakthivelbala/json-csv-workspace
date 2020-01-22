package com.product.input.service;

import java.util.List;

import com.product.input.domain.Product;

public interface ConvertToCsvService {
	
	public String convertData(List<Product> productData);

}
