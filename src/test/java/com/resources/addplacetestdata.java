package com.resources;

import java.util.ArrayList;
import java.util.List;

import com.pojo.gmapsrequestbody;
import com.pojo.location;

public class addplacetestdata {
	
	public gmapsrequestbody addplacepayload(String name,String phonenumber,String address) {
		gmapsrequestbody gm = new gmapsrequestbody();
		gm.setAccuracy(50);
		gm.setName(name);
		gm.setPhone_number(phonenumber);
		gm.setAddress(address);
		gm.setWebsite("http://google.com");
		gm.setLanguage("French-IN");
		
		List<String> li = new ArrayList<String>();
		li.add("shoe park");
		li.add("shop");
		gm.setTypes(li);
		location lo = new location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		gm.setLocation(lo);
		return gm;
	}
	
	public String getdeletebody(String placeid) {
		String place_id = "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
		return place_id;
	}

	

	

}
