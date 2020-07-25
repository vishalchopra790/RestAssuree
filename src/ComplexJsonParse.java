import org.testng.Assert;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\\

		JsonPath js = new JsonPath(PayLoad.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmt);
		String firstTitle = js.get("courses[0].title");
		System.out.println(firstTitle);
		// Print the title and price as well
		for (int i = 0; i < count; i++) {
			String title = js.get("courses[" + i + "].title");
			System.out.println(js.get("courses[" + i + "].price").toString());
			System.out.println(title);
			if (title.equalsIgnoreCase("Rpa")) {
				int copies = js.getInt("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}
			int sum=0;
			for(int j=0;j<count;j++) {
				int price=js.get("courses[" + j + "].price");
				int copies = js.getInt("courses[" + j + "].copies");
				int total=price*copies;
				sum=sum+total;
				
			}System.out.println(sum);
			Assert.assertEquals(sum, purchaseAmt);
		}
	}
}

