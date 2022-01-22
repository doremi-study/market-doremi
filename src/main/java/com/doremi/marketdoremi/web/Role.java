package com.doremi.marketdoremi.web;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "일반사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

    public static Role of(String key) {
        return Arrays.stream(values())
            .filter(v -> v.getKey().equals(key))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못입력하셨습니다. 정확한 권한을 입력해주세요."));
    }
}
