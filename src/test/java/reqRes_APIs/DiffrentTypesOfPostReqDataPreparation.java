package reqRes_APIs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import reqResUtils.PojoTestData;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DiffrentTypesOfPostReqDataPreparation {
	

	// below login is useful to create test data using HashMap and use that test data for POST request.
	@Test
	void testDataFromHashMap() {
		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("name", "tester");
		testData.put("job", "engineer");
		
		
		given()
			.contentType("application/json")
			.body(testData)
		
		.when()
			.post("https://reqres.in/api/userss")
		.then()
			.statusCode(201)
			.log().all();	
		
	}
	
	
	//below login useful to prepare test data using JSON library.
	@Test
	public void testDataFromJsonLibrary() {
		
		
		JSONObject testDataJson = new JSONObject();
		testDataJson.put("name", "testengineer");
		testDataJson.put("job", "test the application");
		
		given()
			.contentType("application/json")
			.body(testDataJson.toString())
		.when()
			.post("https://reqres.in/api/userss")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	// login to create test data using POJO class
	@Test
	public void testDataUsingPOJOClass() {
		
		PojoTestData  dataPOJO = new PojoTestData();
		
		dataPOJO.setName("automation");
		dataPOJO.setJOb("engineer");
		
		given()
			.contentType("application/json")
			.body(dataPOJO)
		.when()
			.post("https://reqres.in/api/userss")
		.then()
			//.statusCode(201)
			.log().all();		
	}
	
	//test data from external JSON file
	@Test
	public void dataFromExternalFile() throws FileNotFoundException {
		//System.out.println(System.getProperty("user.dir")); //D:\Learn\2024\Project
		
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/ReqResTestdata/ReqResTestData.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener token = new JSONTokener(fileReader);
		JSONObject object = new JSONObject(token);
		
		
		given()
			.contentType("application/json")
			.body(object.toString())
		.when()
			.post("https://reqres.in/api/userss")
		.then()
			.statusCode(201)
			.log().all();
		
		
	}
	

}
