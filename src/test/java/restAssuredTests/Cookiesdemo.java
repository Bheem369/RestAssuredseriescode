package restAssuredTests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;




public class Cookiesdemo {
	
	
//	@Test
	void testCookies()
	{
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.cookie("AEC","AVYB7cpS0kP4PKoHyJpqAE9oy4mYs0hTqFdd1ZOxI3cRu-wEiiHsbVRK4A")
		.log().all();
	}

	@Test
	void getcookieInfo()
	{
	   Response res= given()
			   .when()
			   .get("https://www.google.com");
			   
	// String cookie_value = res.getCookie("AEC");
	// System.out.println(cookie_value);
	   
	   System.out.println(res.toString());	   
	//   Map <String,String> cookie_value = res.getCookies();
	//   System.out.println(cookie_value);
	}
}

