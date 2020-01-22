package com.product.input.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.opencsv.CSVWriter;
import com.product.input.Feign.DisplayServiceCommunication;
import com.product.input.domain.Product;

@Service
public class ConvertToCsvServiceImpl implements ConvertToCsvService{

	@Autowired
	private DisplayServiceCommunication displayMicroservice;
	
	public String convertData(List<Product> productData) {
		
		String ResponseString=null;
		File file = new File("D:\\file.csv");
		
	    try {
	    	file.createNewFile();
	        FileWriter outputfile = new FileWriter(file); 
	        CSVWriter writer = new CSVWriter(outputfile);
	        
	        List<String> header=new ArrayList<String>();
	        
	        for(int i=0;i<Product.class.getDeclaredFields().length;i++){
				String productDetailHeader=Product.class.getDeclaredFields()[i].getName();
				header.add(productDetailHeader);
			}
	        writer.writeNext(header.toArray(new String[header.size()]));
	        productData.forEach((x)->{
				Method[] methods=x.getClass().getMethods();
				List<Method> getters=new ArrayList<Method>();
				List<String> data=new ArrayList<String>();
				for (Method method:methods)
			    {
			        if(method.getName().contains("getProduct")){
			        	getters.add(method);
			        }
			    }
				for (Method method:getters)
			    {
					try {
						data.add(method.invoke(x, null).toString());
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
			    }
				writer.writeNext(data.toArray(new String[data.size()]));
				data.clear();
			});
	        writer.close();
	        ResponseString=displayMicroservice.getDataFromCsv(fileIntoBytes(file));
	    } 
	    catch (IOException e) {
	        e.printStackTrace(); 
	    }
	    return ResponseString;
	}
	
	public byte[] fileIntoBytes(File file){
		byte[] bytesArray = new byte[(int) file.length()]; 
		  FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			fis.read(bytesArray);
			fis.close();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		  return bytesArray;
	}
}
