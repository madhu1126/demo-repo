package userApiTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import apiBuilders.PostApiBuilder;
import apiConfigs.ApiPath;
import apiConfigs.HeaderConfigs;
import apiVerification.ResponseValidations;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.PostApiPOJO;
import utils.RandomStringUtil;

public class PostApiAutomateTest extends BaseTest {

	@Test
	public void postApiTest() {
		
		HeaderConfigs headersConf = new HeaderConfigs();
		PostApiBuilder apiBuilder = new PostApiBuilder();
		
		PostApiPOJO postPojo = new PostApiPOJO("Learning Automation", "Budha");
		/*
		 * Response response =
		 * RestAssured.given().when().headers(headersConf.headersWithConnection())
		 * .body(apiBuilder.postApiBody(RandomStringUtil.randomString(20),
		 * RandomStringUtil.randomString(10))).post(ApiPath.apiPath.CREATE_USER);
		 */
		Response response = RestAssured.given().when().headers(headersConf.headersWithConnection())
				.body(postPojo).post(ApiPath.apiPath.CREATE_USER);
				
		
		System.out.println(response.getBody().asString());
		System.out.println(response.statusCode());
		
		System.out.println(postPojo.getAuthor());
		System.out.println(postPojo.getTitle());
		
		Assert.assertEquals("Budha1", postPojo.getAuthor(),"Incorrect author");
		/*
		 * ResponseValidations.responseKeyValidationForJSONObject(response, "author");
		 * ResponseValidations.responseCodeValidation(response, 201);
		 */
	}
}
