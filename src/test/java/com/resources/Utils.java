package com.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
public static RequestSpecification req;
	
	public RequestSpecification requestspecbuilder() throws IOException {
	   if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt") );
			
		req =new RequestSpecBuilder()
				.setBaseUri(globalvalue("baseuri"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	   }
	   return req;
	}
	
	public static String globalvalue(String key) throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\navee\\eclipse-workspace\\Cucumber_API\\src\\test\\java\\com\\resources\\global.properties");
		p.load(fis);
		 return p.getProperty(key);
	}
	
	public String getJsonpath(Response resp,String key) {
		String resppp =   resp.asString();
		JsonPath js = new JsonPath(resppp);
	return	js.get(key).toString();
	}
	
	

}
