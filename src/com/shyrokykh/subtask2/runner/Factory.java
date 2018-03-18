package com.shyrokykh.subtask2.runner;

import com.shyrokykh.subtask2.entity.Carriage;

@FunctionalInterface
public interface Factory {
    Carriage createCarriage(int passengerCapacity, int baggageCapacity);
}
