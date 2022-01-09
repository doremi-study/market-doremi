package com.doremi.marketdoremi.web;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 성별 enum
 */
@Getter
public enum Sex {

    MALE("male"),
    FEMALE("female"),
    NONE("")
    ;

//    @JsonValue
    private final String name;

    Sex(String name) {
        this.name = name;
    }
}
