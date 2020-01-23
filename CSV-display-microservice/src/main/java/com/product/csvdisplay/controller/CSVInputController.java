package com.product.csvdisplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.csvdisplay.service.DisplayContentService;

@RestController
public class CSVInputController {
	
	@Autowired
	private DisplayContentService displayContentService;
	
	@Value("${test.input.param.value}")
	private String testInputParamValue;
	
	@Value("${test.input.incorrect.response}")
	private String incorrectInput;
	
	@Value("${display.service.working.response}")
	private String displayServiceWorking;
	
	@PostMapping("${display.csv.upload.rest.path}")
	public String uploadFile(@RequestParam("${display.csv.file.path.param.name}") byte[] file){
		return displayContentService.fileContentAsString(file);
	}
	
	@PostMapping("${test.rest.path}")
	public String test(@RequestParam("input") String input){
		if(input.equals(testInputParamValue)){
			return displayServiceWorking;
		}
		return incorrectInput;
	}

}
