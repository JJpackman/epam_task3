package com.shyrokykh.subtask2.runner.enums;

public enum MenuCommands {
    ADD_CARRIAGE("Add new carriage"),
    SORT_CARRIAGES("Sort carriages by comfort level"),
    CALC_TOTAL_PASS_CAP("Calculate total passengers capacity"),
    FIND_CARRIAGES_WITH_PASS_CAP_IN_RANGE("Find carriages with passenger capacity in specified range"),
    EXIT("Exit program");

    private final String description;

    MenuCommands(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
