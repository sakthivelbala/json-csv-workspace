package com.product.input.Feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DisplayServiceCommunicationFallback implements DisplayServiceCommunication{
	
	@Value("${file.fallback.response}")
	private String fileFallbackResponse;
	
	@Value("${test.fallback.response}")
	private String testFallbackResponse;

	@Override
	public String getDataFromCsv(byte[] file) {
		// TODO Auto-generated method stub
		return fileFallbackResponse;
	}

	@Override
	public String test(String input) {
		// TODO Auto-generated method stub
		return testFallbackResponse;
	}

}
