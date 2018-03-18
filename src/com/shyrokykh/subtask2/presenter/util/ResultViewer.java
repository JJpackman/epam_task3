package com.shyrokykh.subtask2.presenter.util;

import com.shyrokykh.subtask2.entity.Carriage;
import com.shyrokykh.subtask2.presenter.constant.MessageColors;
import com.shyrokykh.subtask2.presenter.constant.Messages;

import java.util.Arrays;

public final class ResultViewer {
    private ResultViewer() {}

    private static void endMessage() {
        System.out.println();
    }

    private static void printTableData(Carriage... carriages) {
        final String tableHeader = "Passengers | Baggage | Comfort";

        final char[] rowDivider = new char[tableHeader.length()];
        Arrays.fill(rowDivider, '-');

        System.out.println(rowDivider);
        System.out.println(tableHeader);
        System.out.println(rowDivider);

        for (Carriage c : carriages) {
            System.out.println(String.format("%10d | %7d | %7d",
                    c.getPassengerCapacity(), c.getBaggageCapacity(), c.getComfortLevel()));
            System.out.println(rowDivider);
        }
    }

    public static void printMessage(Carriage... carriages) {
        if (carriages != null && carriages.length > 0) {
            System.out.println(Messages.RESULT);
            printTableData(carriages);
        } else {
            System.out.println(Messages.NOT_FOUND);
        }

        endMessage();
    }

    public static void printMessage(String message) {
        System.out.println(message);
        endMessage();
    }

    public static void printError(String message) {
        System.out.println(MessageColors.RED + message + MessageColors.BLACK);
        endMessage();
    }
}
