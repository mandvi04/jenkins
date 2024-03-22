package apiLearning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class APIGetmethod {
@Test
public void getmethod() {
	RestAssured.baseURI="https://reqres.in";
	//Static import concept
	//method chaining
	Response response = given()
.when()
.get("/api/users?page=2")
.then()
.extract()
.response();
	
	System.out.println(response);
	String resp = response.asPrettyString();
	System.out.println(resp);
	System.out.println("Jenkins Remote Trigger");
}

}
