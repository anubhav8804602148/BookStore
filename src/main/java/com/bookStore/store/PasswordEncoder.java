package com.bookStore.store;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPass = "Hermione";
		String encodedPass = encoder.encode(rawPass);
		System.out.println(encodedPass);
	}
}
