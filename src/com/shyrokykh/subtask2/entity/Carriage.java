package com.shyrokykh.subtask2.entity;

public abstract class Carriage implements Cloneable {
    private final int passengerCapacity;
    private final int baggageCapacity;

    public Carriage(int passengerCapacity, int baggageCapacity) {
        this.passengerCapacity = passengerCapacity;
        this.baggageCapacity = baggageCapacity;
    }

    public abstract int getComfortLevel();

    @Override
    public abstract Object clone() throws CloneNotSupportedException;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }
}
