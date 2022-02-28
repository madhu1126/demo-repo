package restAPIsAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApiAutomate {
	
	@Test
	public void getRequestAutomate() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RestAssured.given().param("page","2")
		.when()
		.get("/api/users")
		.then()
		.assertThat()
		.log()
		.all()
		.statusCode(200);
	}

	@Test
	public void getRequestAutomation1() {
		
		RestAssured.baseURI="https://reqres.in";
		
		Response response = RestAssured.given().param("page","2").when().get("/api/users");
		//System.out.println(response.asString());
		//System.out.println(response.asPrettyString());
		System.out.println("status code received : "+response.getStatusCode());
		System.out.println("time taken : "+response.getTime());
		System.out.println("content -type :" + response.getContentType());
	}
}
