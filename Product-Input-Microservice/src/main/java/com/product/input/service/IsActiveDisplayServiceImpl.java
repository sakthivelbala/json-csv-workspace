package com.product.input.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.product.input.Feign.DisplayServiceCommunication;

@Service
public class IsActiveDisplayServiceImpl implements IsActiveDisplayService{
	
	@Autowired
	private DisplayServiceCommunication displayMicroservice;
	
	@Value("${test.input.param.value}")
	private String requestParamValue;
	
	public String testService(){
		return displayMicroservice.test(requestParamValue);
	}

}
