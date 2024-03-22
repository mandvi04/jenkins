package fetchComplexdata;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_ComplexData_specificValue {
	@Test
	public void get_complexdata_specificValue() {
		RestAssured.baseURI="https://reqres.in/api";
		//Static import concept
		//method chaining
		Response response = given()
	.when()
	.get("/users?page=2")
	.then()
	.extract()
	.response();
		JsonPath js= response.jsonPath();
		String lastNameValue=js.getString("data[1].last_name");
		System.out.println(lastNameValue);
		//Fetching the ID of 1st index value
		int idValue=js.getInt("data[1].id");
		System.out.println(idValue);
		//accessing the value of one attribute on behalf another attribute
		int lengthValue=js.getInt("data.size()");
		System.out.println("length of array"+lengthValue);
		for(int i=0; i<lengthValue; i++) {
			String firstName= js.getString("data["+i+"].first_name");
			if(firstName.equals("Byron")) {
				System.out.println(js.getString("data["+i+"].email"));
				
			}
			
		}
}}
