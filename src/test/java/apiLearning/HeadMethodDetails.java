package apiLearning;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeadMethodDetails {
	
	@Test
public void getHeaderDetails() {
		RestAssured.baseURI="https://reqres.in";
		//Static import concept
		//method chaining
		Response response = given()
	.when()
	.get("/api/unknown")
	.then()
	.extract()
	.response();
		
		System.out.println(response);
		String resp = response.asPrettyString();
		System.out.println(resp);
}
}
