package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class parsingComplexJson {

	public static void parseObject(JSONObject jsonObj, String key) {
		
		System.out.println(jsonObj.has(key));
		System.out.println(jsonObj.get(key));
	}
	
	public static void parseNestedJson(JSONObject jsonObj, String key) {
		
		boolean exists = jsonObj.has(key);
		Iterator<?> keys;
		
		String nextKeys;
		
		if(!exists) {
			keys=jsonObj.keys();
			while(keys.hasNext()) {
				nextKeys= (String) keys.next();
				try {
					
					if(jsonObj.get(nextKeys) instanceof JSONObject) {
						if(exists == false) {
							parseNestedJson(jsonObj.getJSONObject(nextKeys), key);
						}
					} else if(jsonObj.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = jsonObj.getJSONArray(nextKeys);
						for(int i=0; i <jsonarray.length();i++) {
							String jsonString = jsonarray.get(i).toString();
							JSONObject innerJson = new JSONObject(jsonString);
							if(exists == false) {
								parseNestedJson(innerJson, key);
							}
						}
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else
		{
			parseNestedJson(jsonObj, key);
		}
	}
	
	public static void main(String[] args) {
		
		String str ="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
		
		
		JSONObject inputData = new JSONObject(str);
		parseNestedJson(inputData, "total_pages");
	}
}
