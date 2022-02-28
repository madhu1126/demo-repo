package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();

	public static Map<String, String> envAndFile() {

		String environment = System.getProperty("env");

		try {
			if (environment.equals("dev")) {

				FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/inputs/dev.properties");
				propMain.load(fisDev);
				fileandenv.put("serverUrl", propMain.getProperty("serverUrl"));
				fileandenv.put("portNumber", propMain.getProperty("portNumber"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));

			} else if (environment.equals("qa")) {
				FileInputStream fisQa = new FileInputStream(System.getProperty("user.dir") + "/inputs/qa.properties");
				propMain.load(fisQa);
				fileandenv.put("serverUrl", propMain.getProperty("serverUrl"));
				fileandenv.put("portNumber", propMain.getProperty("portNumber"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileandenv;
	}
	
	public static Map<String, String> getConfigReader(){
		if(fileandenv==null) {
			fileandenv=envAndFile();
		}
		
		return fileandenv;
	}
}
