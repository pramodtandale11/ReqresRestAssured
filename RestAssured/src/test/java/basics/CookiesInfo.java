package basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class CookiesInfo {

//	@Test (priority = 0)
	 void getUser() {
		
				given()	
				.when()
					.get("https://www.google.com/")
				.then()
					.log().all();

	}
	
	//get single cookie_AEC
	@Test
	void getSingleCookie() {
		Response res = given()	
						.when()
							.get("https://www.google.com/");
		
		String coookie = res.getCookie("AEC");
		System.out.println("The cookie value is =====> "+coookie);

	}
}
