package com.doremi.marketdoremi.common.error.exceptions;

public class DoremiRuntimeException extends RuntimeException {

    private int code;

    public DoremiRuntimeException(String message) {
        super(message);
    }

    public DoremiRuntimeException(String message, int code) {
        super(message);
        this.code = code;
    }
}
