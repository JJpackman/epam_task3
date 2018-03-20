package com.shyrokykh.subtask2.entity;

import java.util.*;

public class Train<T extends Carriage> {
    private final List<T> carriages;

    public Train() {
        this.carriages = new ArrayList<T>();
    }

    public void addCarriage(T carriage) {
        this.carriages.add(carriage);
    }

    public Carriage[] getCarriagesCopy() {
        final Carriage[] copy = new Carriage[this.carriages.size()];

        for (int i = 0; i < copy.length; i++) {
            try {
                copy[i] = (Carriage) carriages.get(i).clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        return copy;
    }
}
