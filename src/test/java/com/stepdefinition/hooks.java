package com.stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class hooks {
	
	@Before
	public void getbeforescenario() throws IOException {
		
		stepdeffinttion sd = new stepdeffinttion();
		if(stepdeffinttion.placeid==null)
		{
		sd.user_needs_to_add_place_payload_with("naveen", "3939398449843434", "sjdjhdjd jdjddjdj oddkdkod");
	    sd.user_needs_to_using_http_request("addplace", "POST");
	    sd.user_needs_to_maps_to_and_need_to_the_request("naveen", "getplace");
	}
	}

}
