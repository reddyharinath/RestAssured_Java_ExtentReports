package api.endpoints;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response createUser(User paylod){
			
		Response	response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(paylod)
							.when()
							.post(Routes.createUser_Post_Url);
	
		return response;
	}

}
