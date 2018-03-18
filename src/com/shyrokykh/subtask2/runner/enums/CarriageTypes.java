package com.shyrokykh.subtask2.runner.enums;

public enum CarriageTypes {
    COMPARTMENT("Compartment"),
    ECONOM("Econom class"),
    FIRST("First class"),
    LUXURY("Luxury");

    private final String description;

    CarriageTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

