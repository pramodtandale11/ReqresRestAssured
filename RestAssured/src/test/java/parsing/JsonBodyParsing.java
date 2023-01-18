package parsing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonBodyParsing {

//Approach 1 : validating with body method
	//@Test (priority = 0)
	 void getUserData() {
		
		given()	
		.when()
			.get("https://reqres.in/api/users/2")		
		.then()
			.statusCode(200)
			.body("data.id",equalTo(2))
			.log().body();
	}
	
	//Approach 2 : validating with testNG assertion
	//	@Test (priority = 1)
		 void validatebyTestNG() {
			
			Response res = given()
			.when()
				.get("https://reqres.in/api/users/2");	
			
			Assert.assertEquals(res.statusCode(), 200);
			
			String id = res.jsonPath().get("data.id").toString();
			Assert.assertEquals(id, "2");
			
			String text = res.jsonPath().getString("support.text").toString();
			Assert.assertEquals(text, "To keep ReqRes free, contributions towards server costs are appreciated!");

		}
		
		//Approach 3 : JSON Object 
		@Test(priority = 2)
		 
		
		void JsonObject1() {
				
				Response res = given()
						.contentType(ContentType.JSON)	
				.when()
					.get("https://reqres.in/api/users?page=2");	
				
				
				JSONObject jo = new JSONObject(res.asString());   //passing string response to json object class as argument
				
				boolean status = false;
				
				for (int i=0; i< jo.getJSONArray("data").length();i++) 
				{
					
					String last_name = jo.getJSONArray("data").getJSONObject(i).getString("last_name").toString();
					
					if (last_name.equals("Howell"))
					{
						status = true;
						break;
					}
					
				}
				
				Assert.assertEquals(status, true);
			}
}
