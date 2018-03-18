package com.shyrokykh.subtask2.entity;

import java.util.*;

public class Train<T extends Carriage> implements Iterable<T> {
    private final List<T> carriages;

    public Train() {
        this.carriages = new ArrayList<T>();
    }

    public void addCarriage(T carriage) {
        this.carriages.add(carriage);
    }

    public List<T> getCarriages() {
        return Collections.unmodifiableList(carriages);
    }

    @Override
    public Iterator<T> iterator() {
        return carriages.iterator();
    }
}
