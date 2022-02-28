package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostApiBuilder {

	public Map<String, String> postApiBody(){
		Map<String, String> apiBody = new HashMap<String, String>();
		apiBody.put("title", "Nikhil");
		apiBody.put("author", "Nikhil");
		
		return apiBody;
	}
}
