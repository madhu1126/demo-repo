package apiVerification;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseValidations {

	public static void responseCodeValidation(Response response, int statusCode) {
		
		Assert.assertEquals(statusCode, response.getStatusCode(), "Incorrect response code received.");
	}
	
	public static void responseKeyValidation(Response response, String key) {
		JSONArray array = new JSONArray(response.getBody().asString());
		
		for(int i=0; i<array.length(); i++) {
			JSONObject jObj = array.getJSONObject(i);
			String requiredKey = (String) jObj.get(key);
			System.out.println(requiredKey);
		}
	}
	
	public static void responseTimeValidation(Response response) {
		
		long responseTime = response.time();
		Assert.assertTrue(responseTime < 5000);
	}
}
