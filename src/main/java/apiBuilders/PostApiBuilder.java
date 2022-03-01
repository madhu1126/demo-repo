package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostApiBuilder {

	public Map<String, String> postApiBody(String title, String author){
		Map<String, String> apiBody = new HashMap<String, String>();
		apiBody.put("title", title);
		apiBody.put("author", author);
		
		return apiBody;
	}
}
