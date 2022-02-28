package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

	public Map<String, String> defaultHeaders() {

		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("Content-Type", "application/json");

		return hmap;
	}

	public Map<String, String> headersWithAccessToken() {

		Map<String, String> headerAccessToken = new HashMap<String, String>();
		headerAccessToken.put("Content-Type", "application/json");
		headerAccessToken.put("Access_Token", "asdfasftewrotj");

		return headerAccessToken;
	}

	public Map<String, String> headersWithJWTtoken() {

		Map<String, String> headerJWT = new HashMap<String, String>();
		headerJWT.put("Content-Type", "application/json");
		headerJWT.put("JWT Token", "eafasd3436");

		return headerJWT;
	}
	
	public Map<String, String> headersWithConnection() {

		Map<String, String> headerConn = new HashMap<String, String>();
		headerConn.put("Content-Type", "application/json");
		headerConn.put("Connection", "keep-alive");

		return headerConn;
	}
}
