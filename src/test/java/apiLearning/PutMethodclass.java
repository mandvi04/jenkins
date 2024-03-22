package apiLearning;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutMethodclass {
	@Test
	public void putmethod() {
		RestAssured.baseURI="https://reqres.in";
		//Static import concept
		//method chaining
		Response response = 
				given()
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}")
				.when()
				.put("/api/users/2")
				.then()
				.extract()
				.response();

		System.out.println(response);
		String resp = response.asPrettyString();
		System.out.println(resp);
		long responsetime = response.getTime();
		System.out.println("Response time taken"+responsetime);
		int responseCode = response.getStatusCode();
		System.out.println("Response Code"+responseCode);
}}
