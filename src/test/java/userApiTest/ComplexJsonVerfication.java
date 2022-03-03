package userApiTest;

import java.util.List;

import org.testng.annotations.Test;

import deserialization.ListUsersPojo;
import deserialization.dataPojo;
import deserializationRevision.ListResourcesPojo;
import io.restassured.RestAssured;
import utils.FileandEnv;

public class ComplexJsonVerfication {
	
	@Test
	public void responseVerify() {
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		
		ListUsersPojo res = RestAssured.given().when().get().as(ListUsersPojo.class);
		//System.out.println(res.getTotal());
		//System.out.println(res.getData());
		
		List<dataPojo> list = res.getData();
		for(int i=0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	@Test
	public void nestedJsonVerification() {
		
		RestAssured.baseURI=FileandEnv.envAndFile().get("serverUrl");
		
		ListResourcesPojo listResources = RestAssured.given().when().get().as(ListResourcesPojo.class);
		System.out.println(listResources.getTotal_pages());
	}

}

