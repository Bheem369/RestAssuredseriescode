package restAssuredTests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HeadersDemo {
	
@Test
	void testHeader()
	{
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server","gws");

	}

@Test
void getHeaders()
{
  Response res=	given()
	              .when()
	                 .get("https://www.google.com");
  
  System.out.println(res.getHeaders());
}
	
	
}
