package com.shyrokykh.subtask2.util;

import com.shyrokykh.subtask2.entity.Carriage;
import com.shyrokykh.subtask2.entity.Train;
import com.shyrokykh.subtask2.util.exception.IllegalHighPassengerCapacityBoundaryException;
import com.shyrokykh.subtask2.util.exception.IllegalLowPassengerCapacityBoundaryException;
import com.shyrokykh.subtask2.util.exception.constant.Messages;

import java.util.*;

public final class TrainInformationDesk {
    private TrainInformationDesk() {}

    public static Carriage[] sort(Train<?> train, Comparator<Carriage> comparator) {
        Carriage[] carriagesCopy = train.getCarriagesCopy();
        Arrays.sort(carriagesCopy, comparator);

        return carriagesCopy;
    }

    public static int calcTotalNumberOfBaggageAndPassengers(Train<?> train) {
        int sum = 0;

        for (Carriage carriage : train.getCarriagesCopy()) {
            sum += carriage.getPassengerCapacity() + carriage.getBaggageCapacity();
        }

        return sum;
    }

    public static Carriage[] getCarriagesWithPassengerCapacityInRange(Train<?> train, int from, int to)
            throws IllegalLowPassengerCapacityBoundaryException, IllegalHighPassengerCapacityBoundaryException {
        if (from <= 0) {
            throw new IllegalLowPassengerCapacityBoundaryException(Messages.ERR_ILLEGAL_LOW_PASSENGER_CAPACITY_BOUNDARY);
        }

        if (to - from < 0) {
            throw new IllegalHighPassengerCapacityBoundaryException(Messages.ERR_ILLEGAL_HIGH_PASSENGER_CAPACITY_BOUNDARY);
        }

        final List<Carriage> carriagesInRange = new ArrayList<>();

        for (Carriage c : train.getCarriagesCopy()) {
            final int capacity = c.getPassengerCapacity();

            if (capacity >= from && capacity <= to) {
                try {
                    carriagesInRange.add((Carriage) c.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }

        return carriagesInRange.toArray(new Carriage[0]);
    }
}
