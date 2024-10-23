package com.graphql;

import static io.restassured.RestAssured.given;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.restassured.path.json.JsonPath;
import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

public class queries {
	
	@Test
	public void queries() {
			int charid = 9905;
		String response =	given().header("Content-Type","application/json")
			.body("{\"query\":\"query($locationId:Int!,$characterId:Int!){\\n  location(locationId:$locationId){\\n    id\\n    name\\n    type\\n    dimension\\n  }\\n  \\n  character(characterId:$characterId){\\n    id\\n    name\\n    type\\n    status\\n    species\\n  }\\n  \\n  episode(episodeId:11116){\\n    id\\n    name\\n    air_date\\n    episode\\n  }\\n  \\n  locations(filters:{name:\\\"USA\\\"}){\\n    info{\\n      count\\n    }\\n  }\\n  \\n  episodes(filters:{name:\\\"the beginning of the end\\\",episode:\\\"4x01\\\"}){\\n    info{\\n      count\\n    }\\n    result{\\n      id\\n      name\\n      air_date\\n      episode\\n      characters{\\n        id\\n        name\\n        \\n      }\\n      created\\n    }\\n  }\\n  \\n}\",\"variables\":{\"locationId\":14729,\"characterId\":"+charid+"}}")

	        .when().post("https://rahulshettyacademy.com/gq/graphql")
	        .then().extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
	String name =	js.get("data.location.name");
	System.out.println(name);
	assertEquals("USA",name);
	}
	
	@Test
	public void mutations() {
		String resp1 =given().log().all().header("Content-Type","application/json")
		.body("{\"query\":\"mutation($locationname:String!,$Charactername:String!,$Episodename:String!){\\n  createLocation(location:{name: $locationname, type: \\\"North america\\\",dimension:\\\"23.4985\\\"} ){\\n    id\\n  }\\n  \\n  createCharacter(character:{name:$Charactername,type:\\\"Comicbookcharacter\\\",status:\\\"Immortal\\\",species:\\\"kryptonian\\\",gender:\\\"Male\\\",image:\\\"Superman.png\\\",originId:14727,locationId:14727}){\\n    id\\n  }\\n  \\n  createEpisode(episode:{name:$Episodename,air_date:\\\"7th october 2024\\\",episode:\\\"4x01\\\"}){\\n    id\\n  }\\n  \\n}\\n\",\"variables\":{\"locationname\":\"United states of america\",\"Charactername\":\"Superman\",\"Episodename\":\"The beginning of the end episode\"}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().extract().response().asString();
	System.out.println(resp1);
	JsonPath js = new JsonPath(resp1);
int id =	js.getInt("data.createLocation.id");
System.out.println(id);	
	
	
	
	}
	
	
	
	
	

}
