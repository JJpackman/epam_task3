package com.shyrokykh.subtask2.entity;

import com.shyrokykh.subtask2.entity.constant.ComfortLevels;

public class CompartmentCarriage extends Carriage {
    public CompartmentCarriage(int passengerCapacity, int baggageCapacity) {
        super(passengerCapacity, baggageCapacity);
    }

    @Override
    public int getComfortLevel() {
        return ComfortLevels.LOW;
    }
}
