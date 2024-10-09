package restAssuredTests;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args)
	{
		JsonPath js = new JsonPath(Payload.coursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String title = js.getString("courses[0].title");
		System.out.println(title);
		
		for(int i=0; i<count;i++)
		{
			String coursetitles=js.getString("courses["+i+"].title");
			String pricedetails=js.getString("courses["+i+"].price");
			System.out.println(coursetitles);
			System.out.println(pricedetails);
			
		}
		
		
		
		for(int i=0; i<count;i++)
		{
			String coursetitles=js.getString("courses["+i+"].title");
			if(coursetitles.equalsIgnoreCase("rpa"))
			{
				String noc = js.getString("courses["+i+"].copies");
				System.out.println("Total copies of RPA course: "+noc);
			}
			
		}
		
		int calprice = 0;
		for(int i=0; i<count;i++)
		{
			int pr=js.getInt("courses["+i+"].price");
			int cp=js.getInt("courses["+i+"].copies");
			calprice = calprice + (pr*cp);
			
			if(totalAmount==calprice)
			{
				System.out.println("All course prizes("+calprice+") matches with Purchase Amount("+totalAmount+")");
			}
			
			
		}
		
		
	}
}
