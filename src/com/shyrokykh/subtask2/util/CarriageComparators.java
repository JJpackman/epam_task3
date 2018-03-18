package com.shyrokykh.subtask2.util;

import com.shyrokykh.subtask2.entity.Carriage;

import java.util.Comparator;

public final class CarriageComparators {
    public static Comparator<Carriage> comfortComparator() {
        return new Comparator<Carriage>() {
            @Override
            public int compare(Carriage o1, Carriage o2) {
                return o2.getComfortLevel() - o1.getComfortLevel();
            }
        };
    }
}
