package restAssuredTests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DemoProject {
	
	String placeid;	
	
	
@Test(priority=1)	
void addPlaceAPI() throws IOException
{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\DELL\\Documents\\addPlace.json"))))
			.when().post("/maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
			.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
	
	System.out.println(Response);
	JsonPath js=new JsonPath(Response);
 	placeid=js.getString("place_id");
	System.out.println("placeid= " +placeid);
		
}

//@Test(priority=2)
void updateAPI()
{
	String newaddress = "70 Summer walk, USA";
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\""+newaddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	.when().put("/maps/api/place/update/json")
	.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
}

//@Test(priority=3)
void getApI()
{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "qaclick123").queryParam("place_id", ""+placeid+"").header("Content-Type","application/json")
	.when().get("/maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200).body("address",equalTo("70 Summer walk, USA"));
	
}
}
