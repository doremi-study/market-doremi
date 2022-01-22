package com.doremi.marketdoremi.web;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum Grade {
	DO("do"), RE("re"), MI("mi");

	private final String key;

	Grade(String key) {
		this.key = key;
	}

	public static Grade of(String grade) {
		return Arrays.stream(values())
			.filter(v -> v.getKey().equals(grade))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못입력하셨습니다. 정확한 등급을 입력해주세요."));
	}
}
