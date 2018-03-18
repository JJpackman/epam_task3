package com.shyrokykh.subtask2.util.exception;

public class IllegalHighPassengerCapacityBoundaryException extends Exception {
    private static final long serialVersionUID = -4867788570753626855L;

    public IllegalHighPassengerCapacityBoundaryException(String message) {
        super(message);
    }

    public IllegalHighPassengerCapacityBoundaryException(String message, Throwable cause) {
        super(message, cause);
    }
}
