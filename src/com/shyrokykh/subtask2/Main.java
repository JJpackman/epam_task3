package com.shyrokykh.subtask2;

import com.shyrokykh.subtask2.entity.*;
import com.shyrokykh.subtask2.util.ComfortComparator;

public class Main {
    public static void main(String[] args) {
        Train<Carriage> train = new Train<Carriage>();

        train.addCarriage(new LuxuryCarriage(20, 16));
        train.addCarriage(new FirstClassCarriage(25, 10));
        train.addCarriage(new EconomClassCarriage(55, 20));

        train.sort(new ComfortComparator());

        for (Carriage c : train) {
            System.out.println(c);
        }

        System.out.println(train.calcTotalNumberOfBaggageAndPassengers());
    }
}
