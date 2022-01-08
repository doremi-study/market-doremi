package com.doremi.marketdoremi.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public class PasswordEncryptor {

	//private final PasswordEncoder passwordEncoder;

	public static String encrypt(String rawPassword){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(rawPassword);
	}
}
