package com.shyrokykh.subtask2.runner.exception;

public class IllegalCarriageTypeException extends Exception {
    private static final long serialVersionUID = -769125869830486247L;

    public IllegalCarriageTypeException(String message) {
        super(message);
    }

    public IllegalCarriageTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
