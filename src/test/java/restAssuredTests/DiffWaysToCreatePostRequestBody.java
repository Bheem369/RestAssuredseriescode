package restAssuredTests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DiffWaysToCreatePostRequestBody {
	
//	@Test
	void testpostusingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name", "scott");
		data.put("active", false);
		data.put("yearsOld", 16);
		data.put("color", "violet");
		double gradesArr[]= {5.0,6.0,5.0};
		data.put("grades", gradesArr);
		
		given()
		   .contentType("application/json")
		   .body(data)
		   
	    .when()
	        .post("http://localhost:3000/students")
	        
	    .then()
	        .statusCode(201)
		    .body("name",equalTo("scott"))
		    .body("color",equalTo("violet"))
		    .body("active",equalTo(false))
		    .log().all();
	    

}
	
	//@Test
	void testpostusingJsonLibrary()
	{
		JSONObject data1 = new JSONObject();
		
		data1.put("name","rajesh");
		data1.put("color","darkblue");
		data1.put("yearsOld","20");
		
		given()
		    .contentType("application/json")
		    .body(data1.toString())
		    
		.when()
		     .post("http://localhost:3000/students")
		     
		.then()
		     .statusCode(201)
		     .body("name",equalTo("rajesh"))
			 .body("color",equalTo("darkblue"))
			 .body("yearsOld",equalTo("20"))
			 .log().all();
	}
	
	@Test
	void testDelete()
	{
		given()
		
		.when()
		 .delete("http://localhost:3000/students/87aa")
		 
		 
		 .then()
		  .statusCode(200);
	}
}
