package util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Random {
	private static SecureRandom random = new SecureRandom();
	
	public static String nextSessionId() {
	    return new BigInteger(60, random).toString(32);
	}
}
