package com.doremi.marketdoremi.common.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class ErrorResult {

    private int code;
    private String message;
}
