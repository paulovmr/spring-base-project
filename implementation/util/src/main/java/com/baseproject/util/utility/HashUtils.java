package com.baseproject.util.utility;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class HashUtils {

	public static String sha256(String string) {
		try {
			PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
			return passwordEncoder.encode(string);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
