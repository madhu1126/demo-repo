package userApiTest;

import org.testng.annotations.Test;

import apiBuilders.PostApiBuilder;
import apiConfigs.ApiPath;
import apiConfigs.HeaderConfigs;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostApiAutomateTest extends BaseTest {

	@Test
	public void postApiTest() {
		
		HeaderConfigs headersConf = new HeaderConfigs();
		PostApiBuilder apiBuilder = new PostApiBuilder();
		
		Response response = RestAssured.given().when().headers(headersConf.headersWithConnection())
		.body(apiBuilder.postApiBody()).post(ApiPath.apiPath.CREATE_USER);
		
		System.out.println(response.getBody().asString());
		System.out.println(response.statusCode());
	}
}
