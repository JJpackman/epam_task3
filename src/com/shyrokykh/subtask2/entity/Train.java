package com.shyrokykh.subtask2.entity;

import java.util.*;

public class Train<T extends Carriage> implements Iterable<T> {
    private List<T> carriages;

    public Train() {
        this.carriages = new ArrayList<T>();
    }

    public void addCarriage(T carriage) {
        this.carriages.add(carriage);
    }

    public void sort(Comparator<? super T> comparator) {
        Collections.sort(carriages, comparator);
    }

    public int calcTotalNumberOfBaggageAndPassengers() {
        int sum = 0;

        for (T carriage : carriages) {
            sum += carriage.getPassengerCapacity() + carriage.getBaggageCapacity();
        }

        return sum;
    }

    @Override
    public Iterator<T> iterator() {
        return carriages.iterator();
    }
}
