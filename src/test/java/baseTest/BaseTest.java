package baseTest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utils.FileandEnv;

public class BaseTest {
	
	@BeforeClass
	public void baseTest() {
		
		RestAssured.baseURI=FileandEnv.envAndFile().get("serverUrl");
		
	}

}
