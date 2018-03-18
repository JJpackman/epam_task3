package com.shyrokykh.subtask2.util;

import java.util.Scanner;

public final class UserInput {
    private static final Scanner INPUT = new Scanner(System.in);

    private UserInput() {}

    public static int readInt() {
        return Integer.parseInt(INPUT.nextLine());
    }

    public static String readString() {
        return INPUT.nextLine();
    }
}
