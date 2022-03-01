package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtil {

	public static String randomString(int size) {
		
		String randomStr = RandomStringUtils.randomAlphabetic(size);
		return randomStr;
	}
}
