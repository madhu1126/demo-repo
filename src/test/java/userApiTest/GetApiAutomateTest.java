package userApiTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import apiConfigs.ApiPath;
import apiVerification.ResponseValidations;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApiAutomateTest extends BaseTest{
	
	@Test
	public void getApiTest() {
		
		/*
		 * RestAssured.given().when().get(ApiPath.apiPath.GET_ALL_USERS)
		 * .then().log().all().assertThat().statusCode(200);
		 */
		
		Response response = RestAssured.given().when().get(ApiPath.apiPath.GET_ALL_USERS);
		/*
		 * System.out.println(response.getBody().asString());
		 * System.out.println(response.getStatusCode());
		 *
		
		 * JSONArray arr = new JSONArray(response.getBody().asString()); for(int i=0; i
		 * <arr.length(); i++) { JSONObject obj = arr.getJSONObject(i);
		 * System.out.println(obj.get("author")); }
		 */
		ResponseValidations.responseCodeValidation(response, 200);
		ResponseValidations.responseKeyValidation(response, "title");
		ResponseValidations.responseTimeValidation(response);
	}

}


