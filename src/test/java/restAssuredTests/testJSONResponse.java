package restAssuredTests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class testJSONResponse {
	
	//@Test
	void testresponse()
	{
		given()
		.contentType("application/json")
		.when()
		.get("http://localhost:3000/students/303")
		.then()
		.statusCode(200)
		.body("yearsOld",equalTo(17));
	}
	
	@Test
	void testres()
	{
		
	 Response res = given()
				       .contentType("application/json")
				       .when()
				       .get("http://localhost:3000/students");
	 
	 JSONObject jo = new JSONObject(res.toString());
	 
	 for(int i=0; i<jo.getJSONArray("students").length();i++)
	 {
		 String bt=jo.getJSONArray("students").getJSONObject(i).get("color").toString();
		 System.out.println(bt);
	 }
	 
                  //      .jsonPath().getInt("yearsOld");
		
	//	System.out.println("yearsOld: "+age);
		
	//	Assert.assertEquals(age,17);
		
		
	}
//	http://localhost:3000/students/students[2]

}
