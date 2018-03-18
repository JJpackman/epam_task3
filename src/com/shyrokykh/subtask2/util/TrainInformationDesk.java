package com.shyrokykh.subtask2.util;

import com.shyrokykh.subtask2.entity.Carriage;
import com.shyrokykh.subtask2.entity.Train;
import com.shyrokykh.subtask2.util.exception.IllegalHighPassengerCapacityBoundaryException;
import com.shyrokykh.subtask2.util.exception.IllegalLowPassengerCapacityBoundaryException;
import com.shyrokykh.subtask2.util.exception.constant.Messages;

import java.util.*;

public final class TrainInformationDesk {
    private TrainInformationDesk() {}

    private static Carriage[] cloneCarriageCollectionItemsToArray(List<? extends Carriage> src) {
        final Carriage[] clone = new Carriage[src.size()];

        for (int curr = 0; curr < clone.length; curr++) {
            Carriage temp = src.get(curr);

            try {
                clone[curr] = (Carriage) temp.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        return clone;
    }

    public static Carriage[] sort(Train<?> train, Comparator<? super Carriage> comparator) {
        Carriage[] carriagesCopy = cloneCarriageCollectionItemsToArray(train.getCarriages());
        Arrays.sort(carriagesCopy, comparator);

        return carriagesCopy;
    }

    public static int calcTotalNumberOfBaggageAndPassengers(Train<?> train) {
        int sum = 0;

        for (Carriage carriage : train.getCarriages()) {
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

        for (Carriage c : train.getCarriages()) {
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
