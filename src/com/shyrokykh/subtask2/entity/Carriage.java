package com.shyrokykh.subtask2.entity;

public abstract class Carriage implements Cloneable {
    private int passengerCapacity;
    private int baggageCapacity;

    public Carriage(int passengerCapacity, int baggageCapacity) {
        this.passengerCapacity = passengerCapacity;
        this.baggageCapacity = baggageCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public abstract int getComfortLevel();

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    @Override
    public String toString() {
        return String.format("Passengers: %d, baggage: %d, level of comfort: %d",
                passengerCapacity, baggageCapacity, getComfortLevel());
    }
}
