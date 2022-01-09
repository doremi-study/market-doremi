package com.doremi.marketdoremi.common.utils;

import java.util.regex.Pattern;

public class StringValidator {

	private StringValidator() {
		throw new AssertionError();
	}

	public static boolean isAlpha(String str) {
		return Pattern.matches("^[a-z]*$", str);
	}

	public static boolean isNumeric(String str) {
		return Pattern.matches("^[0-9]*$", str);
	}

	public static boolean isAlphaNumeric(String str) {
		return Pattern.matches("[a-z0-9]*$", str);
	}

	public static boolean isValidPassword(String str) {
		return Pattern.matches("^(?=.*\\\\d)(?=.*[~`!@#$%\\\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$", str);
	}
}
