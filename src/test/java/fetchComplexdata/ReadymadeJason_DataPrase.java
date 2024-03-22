package fetchComplexdata;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ReadymadeJason_DataPrase {
	@Test
	public void readymadeJason_Data() {
		String data = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}";
		JsonPath js=new JsonPath(data);	
		int numOfCourses = js.getInt("courses.size()");
		System.out.println("Number of courses: "+numOfCourses );
		int purchase_Amount_Value = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount Value: "+ purchase_Amount_Value);
		String title_Value=js.getString("courses[0].title");
		System.out.println("Title of the first course: "+title_Value );
		int price=0;
		int totalPA=0;
		for(int i=0; i<numOfCourses; i++) {
			String title_values= js.getString("courses["+i+"].title");
			int prices= js.getInt("courses["+i+"].price");
			int copy= js.getInt("courses["+i+"].copies");
			System.out.println("Title of the courses: "+title_values );
			System.out.println("Prices of the courses: "+prices );
			if(title_values.equals("RPA")) {
				System.out.println("Number of Copies sold by RPA Course: "+js.getString("courses["+i+"].copies"));

			}
			//String price_values= js.getString("courses["+i+"].price");

			price= prices+price;
			int PAofeachCourses=prices*copy;
			totalPA=PAofeachCourses+totalPA;

		}
		System.out.println("Sum of all courses prices: "+price);
		System.out.println("Sum of all Purchase amount: "+ totalPA);

		Assert.assertEquals(totalPA,purchase_Amount_Value );

	}


}
