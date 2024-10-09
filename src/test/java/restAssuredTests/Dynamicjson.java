package restAssuredTests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Dynamicjson {
	
	@Test(dataProvider="Booksdata")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().log().all().header("Content-Type","application/json")
		.body(Payload.AddBook(isbn,aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		System.out.println(js.get("ID"));
        System.out.println(js.get("Msg")); 		
	}
	
	
	@DataProvider(name="Booksdata")
	public Object[][] getData()
	{
		return new Object[][] {{"vsg","133"},{"tqe","344"},{"spd","788"}};
	}

		
}


//  C:\Users\DELL\Documents\addPlace.json
