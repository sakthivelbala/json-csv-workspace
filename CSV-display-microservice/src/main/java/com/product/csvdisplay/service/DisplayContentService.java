package com.product.csvdisplay.service;


import org.springframework.web.multipart.MultipartFile;


public interface DisplayContentService {
	
	public String fileContentAsString(MultipartFile file);

}
