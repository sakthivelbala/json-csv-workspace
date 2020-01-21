package com.product.input.service;

import java.util.List;

import com.product.input.domain.Product;

public interface ConvertToCsvService {
	
	public void convertData(List<Product> productData);

}
