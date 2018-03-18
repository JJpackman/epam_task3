package com.shyrokykh.subtask2.util;

import com.shyrokykh.subtask2.entity.*;

public final class CarriageFactory {
    private CarriageFactory() {}

    public static Carriage createCompartmentCarriage(int passengerCapacity, int baggageCapacity) {
        return new CompartmentCarriage(passengerCapacity, baggageCapacity);
    }

    public static Carriage createEconomClassCarriage(int passengerCapacity, int baggageCapacity) {
        return new EconomClassCarriage(passengerCapacity, baggageCapacity);
    }

    public static Carriage createFirstClassCarriage(int passengerCapacity, int baggageCapacity) {
        return new FirstClassCarriage(passengerCapacity, baggageCapacity);
    }

    public static Carriage createLuxuryCarriage(int passengerCapacity, int baggageCapacity) {
        return new LuxuryCarriage(passengerCapacity, baggageCapacity);
    }
}
