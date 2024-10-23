package com.graphql;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class oauth_twopoint_o {
	
	public static void main(String[] args) {
		

		
		
		
		given().log().all()
		.queryParams("code", "4%2F0AVG7fiQu7zSNMiaNjjDWwZrpPeYzmR3vhDdPYu1tkw3RQZwv4MV4ImtIbRep_JYH7tokbw")
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		
		
		.when().log().all().
		post("https://www.googleapis.com/oauth2/v4/token").then().log().all();
		
		
		
		
		
		
		
		
		
		
		
	}

}
