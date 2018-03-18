package com.shyrokykh.subtask2.runner.exception;

public class IllegalMenuItemException extends Exception {
    private static final long serialVersionUID = 3559885455118365731L;

    public IllegalMenuItemException(String message) {
        super(message);
    }

    public IllegalMenuItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
