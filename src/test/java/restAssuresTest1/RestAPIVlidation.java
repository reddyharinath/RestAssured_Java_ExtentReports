package restAssuresTest1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAPIVlidation {
	
	
	// execute get method to get single user data
	@Test(priority=0)
	void getSingleUser(){		
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();			
	}
	// capture the id from response and print that id value in console...
	@Test
	void extractIdValueFromResponse() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all()
			.assertThat().statusCode(200)
			.body("data.first_name",equalTo("Janet"))
			.body("data.id",equalTo(2));
	}
	

}
