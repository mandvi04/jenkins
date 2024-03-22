package apiLearning;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;




public class PatchMethodClass {
	@Test
	public void getmethod() {
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
				.patch("/api/users/2")
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
		
		
	}


}
