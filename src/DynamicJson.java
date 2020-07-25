import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUssableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {

	@Test(dataProvider = "getData", priority = 1, enabled = true)
	public void addTest(String isbn, String aisle) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(PayLoad.addBook(isbn, aisle)).when().post("/Library/Addbook.php").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();
		JsonPath js = ReUssableMethods.rawToJson(response);

		//String id = js.getString("ID");
		//System.out.println(id);

	}

	@Test(dataProvider = "getData", priority = 2, enabled = false)
	public void deleteBook(String isbn, String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type", "application/json").body(PayLoad.deleteBook(isbn, aisle)).when()
				.post("/Library/DeleteBook.php").then().log().all().assertThat().statusCode(200);

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "Val";
		obj[0][1] = "17j6";
		obj[1][0] = "Sajjkka0";
		obj[1][1] = "98hjjjj";

		return obj;

	}

}
