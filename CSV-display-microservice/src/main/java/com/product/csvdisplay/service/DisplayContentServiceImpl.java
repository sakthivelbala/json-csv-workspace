package com.product.csvdisplay.service;

import org.springframework.stereotype.Service;


@Service
public class DisplayContentServiceImpl implements DisplayContentService {
	
	public String fileContentAsString(byte[] file){
		return new String(file);
	}

}
