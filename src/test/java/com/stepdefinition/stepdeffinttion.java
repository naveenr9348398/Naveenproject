package com.stepdefinition;

import org.junit.runner.*;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.gmapsrequestbody;
import com.pojo.location;
import com.resources.Utils;
import com.resources.addplacetestdata;
import com.resources.enumhttpresources;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepdeffinttion extends Utils {
	ResponseSpecification respp;
	RequestSpecification reqspec;
	Response resp;
	static String placeid;
	addplacetestdata ad = new addplacetestdata();
	
	@Given("User needs to Add place payload with {string} {string} {string}")
	public void user_needs_to_add_place_payload_with(String name, String phonenum, String address) throws IOException {
		
		
	 reqspec =    given().spec(requestspecbuilder())
	    .body(ad.addplacepayload(name,phonenum,address));
	}
	@When("User needs to {string} using {string} http request")
	public void user_needs_to_using_http_request(String resource, String httpcall) {
     enumhttpresources method =		enumhttpresources.valueOf(resource);
     System.out.println(method.getresource());
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     System.out.println("output1");
     respp =	new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
        if(httpcall.equalsIgnoreCase("POST"))
		resp =	  reqspec.when().post(method.getresource());
		else if(httpcall.equalsIgnoreCase("GET"))
		resp =	  reqspec.when().get(method.getresource());
			
	}
	
	@Then("User needs to validate if status code is {int}")
	public void user_needs_to_validate_if_status_code_is(Integer int1) {
	 assertEquals(   resp.getStatusCode(),200);
	}
	@Then("User needs to validate the response body and check {string} is {string}")
	public void user_needs_to_validate_the_response_body_and_check_is(String key, String value) {
	
    assertEquals(getJsonpath(resp, key), value);
	}
	
	@Then("user needs to maps to {string} and need to {string} the request")
	public void user_needs_to_maps_to_and_need_to_the_request(String expectedname, String resource) throws IOException {
    placeid =	  getJsonpath(resp, "place_id");
	System.out.println(placeid);	
    reqspec =    given().spec(requestspecbuilder()).queryParam("place_id", placeid);
	    user_needs_to_using_http_request(resource, "GET");
	    String actualname =	  getJsonpath(resp, "name");
	    assertEquals(actualname, expectedname);
	    
	}
	
	@Given("User needs to add delete place payload")
	public void user_needs_to_add_delete_place_payload() throws IOException {
		reqspec =    given().spec(requestspecbuilder()).body(ad.getdeletebody(placeid));
	    
	}
	
	
	
	
	
	
	
	
	
	

}
