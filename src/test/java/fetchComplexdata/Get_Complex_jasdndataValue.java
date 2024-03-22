package fetchComplexdata;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Complex_jasdndataValue {

	@Test
	public void get_firstName_fromJasonData() {
		RestAssured.baseURI="https://reqres.in/api";
		//Static import concept
		//method chaining
		Response response = given()
	.when()
	.get("/users/2")
	.then()
	.extract()
	.response();
		
		JsonPath js= response.jsonPath();
		String firstNameValue=js.getString("data.first_name");
		System.out.println(firstNameValue);
		String lastNameValue=js.getString("data.last_name");
		System.out.println(lastNameValue);
		
	}
}
