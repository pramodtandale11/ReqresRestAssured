package basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class QueryandPathParam {

	@Test
	void getUser() {

		given()
			.pathParam("mypath", "users")
			.queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
}
