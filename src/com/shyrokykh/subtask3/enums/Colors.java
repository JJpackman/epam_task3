package com.shyrokykh.subtask3.enums;

public class Colors extends MyEnum<Colors> {
    public static final Colors BLACK = new Colors("BLACK");
    public static final Colors RED = new Colors("RED");

    public Colors(String name) {
        super(name);
    }
}