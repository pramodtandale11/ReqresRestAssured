package basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersInfo {

	// to validate headers
	@Test(priority = 0)
	void validateHeaders() {

		given().when().get("https://www.google.com/").then().header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip");

	}

//to print single header	
	@Test(priority = 1)
	void getSingleHeader() {

		Response res = given().when().get("https://www.google.com/");
		String header_value = res.getHeader("Content-Type");
		System.out.println("The header value is =========>  " + header_value);

	}

// get list of headers
	@Test(priority = 2)
	void getListHeader() {

		Response res = given().when().get("https://www.google.com/");
		Headers header_value = res.getHeaders();

		for (Header ht : header_value) {
			System.out.println(ht.getName() + "===========> " + ht.getValue());
		}

	}

// simple way with available method to get header
	@Test(priority = 3)
	void getHeaders() {

		given().when().get("https://www.google.com/").then().log().headers();
	}

}
