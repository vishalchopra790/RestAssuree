import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class SumAllCourses {
	
	@Test
	public void sumCourses() {
		JsonPath js = new JsonPath(PayLoad.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmt);
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
