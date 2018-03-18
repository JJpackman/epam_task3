package com.shyrokykh.subtask2.util.exception;

public class IllegalLowPassengerCapacityBoundaryException extends Exception {
    private static final long serialVersionUID = -3077279604302689450L;

    public IllegalLowPassengerCapacityBoundaryException(String message) {
        super(message);
    }

    public IllegalLowPassengerCapacityBoundaryException(String message, Throwable cause) {
        super(message, cause);
    }
}
