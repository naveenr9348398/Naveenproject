package com.resources;

public enum enumhttpresources {
	
	addplace("maps/api/place/add/json"),
	getplace("maps/api/place/get/json"),
	deleteplace("maps/api/place/delete/json");
	private String resource;
	
	enumhttpresources(String resource) {
	 this.resource = resource;	
	}
	
	public String getresource() {
		return resource;
	}

}
