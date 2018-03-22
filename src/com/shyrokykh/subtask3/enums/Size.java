package com.shyrokykh.subtask3.enums;

public class Size extends MyEnum<Size> {
    public static final Size LARGE = new Size("LARGE");
    public static final Size SMALL = new Size("SMALL");
    public static final Size MIDDLE = new Size("MIDDLE");

    public Size(String name) {
        super(name);
    }
}
