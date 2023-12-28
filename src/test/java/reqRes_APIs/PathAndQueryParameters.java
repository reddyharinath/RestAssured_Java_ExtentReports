package reqRes_APIs;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {

	
	//login to capture 9th id user data from page 2 without query and path parameters
	//@Test
	public void pathParamTest() {
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2&id=9")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	//login to capture 9th id user data from page 2 with path parameters
	//@Test
	public void pathParametersTest() {
		
		given()
			.pathParam("apiPath", "api")
			.pathParam("usersPath", "users")
		.when()
			.get("https://reqres.in/{apiPath}/{usersPath}?page=2&id=9")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//login to capture 9th id user data from page 2 with query and path parameters
	@Test
	public void withQueryAndPathParams() {
		
		given()
			.pathParam("apiPath", "api")
			.pathParam("userPath", "users")
			.queryParam("page", 2)
			.queryParam("id", 9)
		.when()
			.get("https://reqres.in/{apiPath}/{userPath}")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
}
