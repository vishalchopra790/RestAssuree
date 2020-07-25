package files;

import io.restassured.path.json.JsonPath;

public class ReUssableMethods {
	
	public static JsonPath rawToJson(String response){
		JsonPath jss=new JsonPath(response);
		return jss;
		
	}

}
