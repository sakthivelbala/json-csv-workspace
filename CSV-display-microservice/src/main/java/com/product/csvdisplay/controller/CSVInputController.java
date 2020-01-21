package com.product.csvdisplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.product.csvdisplay.service.DisplayContentService;

@RestController
public class CSVInputController {
	
	@Autowired
	private DisplayContentService displayContentService;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file){
		return displayContentService.fileContentAsString(file);
	}

}