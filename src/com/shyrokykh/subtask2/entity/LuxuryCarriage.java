package com.shyrokykh.subtask2.entity;

import com.shyrokykh.subtask2.entity.constant.ComfortLevels;

public class LuxuryCarriage extends Carriage implements Cloneable {
    public LuxuryCarriage(int passengerCapacity, int baggageCapacity) {
        super(passengerCapacity, baggageCapacity);
    }

    @Override
    public int getComfortLevel() {
        return ComfortLevels.HIGH;
    }

    @Override
    public Object clone() {
        return new LuxuryCarriage(getPassengerCapacity(), getBaggageCapacity());
    }
}
