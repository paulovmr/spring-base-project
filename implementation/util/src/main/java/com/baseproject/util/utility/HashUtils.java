package com.baseproject.util.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class HashUtils {

	public static String sha256(String string) {
		try {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			return passwordEncoder.encode(string);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(sha256("123"));
	}
}
