package apiVerification;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.response.Response;

public class ResponseValidations {

	public static void responseCodeValidation(Response response, int statusCode) {

		Assert.assertEquals(statusCode, response.getStatusCode(), "Incorrect response code received.");
	}

	public static void responseKeyValidationForJSONArray(Response response, String key) {
		JSONArray array = new JSONArray(response.getBody().asString());

		for (int i = 0; i < array.length(); i++) {
			JSONObject jObj = array.getJSONObject(i);
			String requiredKey = (String) jObj.get(key);
			System.out.println(requiredKey);
			
		}
	}

	public static void responseKeyValidationForJSONObject(Response response, String key) {

		JSONObject obj = new JSONObject(response.getBody().asString());
		if (obj.has(key) && obj.get(key) != null) {
			System.out.println(obj.get(key));
		} else {
			System.out.println(key + "is not found.");
		}
	}

	public static void responseTimeValidation(Response response) {

		long responseTime = response.time();
		Assert.assertTrue(responseTime < 5000);
	}
}
