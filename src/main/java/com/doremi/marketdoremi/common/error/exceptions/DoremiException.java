package com.doremi.marketdoremi.common.error.exceptions;

public class DoremiException extends Exception {

    private int code;

    public DoremiException(String message, String message1) {
        super(message);
    }

    public DoremiException(String message, int code) {
        super(message);
        this.code = code;
    }
}
