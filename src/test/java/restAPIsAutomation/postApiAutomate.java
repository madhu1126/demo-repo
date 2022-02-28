package restAPIsAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postApiAutomate {

	@Test
	public void postApiAutomation() {
		RestAssured.baseURI="https://reqres.in";
		
		String bodyContent = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		RestAssured.given().body(bodyContent).when().post("/api/users")
				.then()
				.log()
				.all()
				.assertThat().statusCode(201);
	}
}
