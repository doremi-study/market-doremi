package com.doremi.marketdoremi.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "일반사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
