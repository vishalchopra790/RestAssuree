import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUssableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	
	@Test
	public void addTest() throws IOException {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(generateStringFormatResource("C:\\Users\\Administrator\\eclipse-workspace\\RestAssured\\Addbook.json")).when().post("/Library/Addbook.php").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();
		JsonPath js = ReUssableMethods.rawToJson(response);

		String id = js.getString("ID");
		System.out.println(id);

	}
	public static String generateStringFormatResource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
