package com.product.input.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import com.opencsv.CSVWriter;
import com.product.input.domain.Product;

@Service
public class ConvertToCsvServiceImpl implements ConvertToCsvService{

	
	public void convertData(Product productData) {
		
		System.out.println(productData.toString());
		
		
		File file = new File("/file.csv");
		
	    try {
	    	file.createNewFile();
	    	
	    	
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        // adding header to csv 
	        String[] header = { "Name", "Class", "Marks" }; 
	        writer.writeNext(header); 
	  
	        // add data to csv 
	        String[] data1 = { "Aman", "10", "620" }; 
	        writer.writeNext(data1); 
	        String[] data2 = { "Suraj", "10", "630" }; 
	        writer.writeNext(data2); 
	  
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    }
		
		
	}
	
	
}
