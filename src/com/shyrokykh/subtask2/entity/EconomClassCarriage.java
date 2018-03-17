package com.shyrokykh.subtask2.entity;

import com.shyrokykh.subtask2.entity.constant.ComfortLevels;

public class EconomClassCarriage extends Carriage {
    public EconomClassCarriage(int passengerCapacity, int baggageCapacity) {
        super(passengerCapacity, baggageCapacity);
    }

    @Override
    public int getComfortLevel() {
        return ComfortLevels.LOW;
    }
}

