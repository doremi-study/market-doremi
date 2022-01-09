package com.doremi.marketdoremi.domain.memberinfo.entity;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum Gender {
	FEMALE("female"), MALE("male"), UNCHECKED("unchecked");

	private final String key;

	Gender(String key) {
		this.key = key;
	}

	public static Gender of(String key) {
		return Arrays.stream(values())
					.filter(v -> v.getKey().equals(key))
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("정확한 성별을 입력해주세요."));
	}

}
