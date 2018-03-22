package com.shyrokykh.subtask3.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class MyEnum<E extends MyEnum<E>> implements Comparable<E> {
    private static final Map<Class<? extends MyEnum>, List<MyEnum>> DERIVED_ENUMS_MAP = new LinkedHashMap<>();
    private final String name;

    public MyEnum(String name) {
        this.name = name;
        Class<? extends MyEnum> eClass = this.getClass();

        if (!DERIVED_ENUMS_MAP.containsKey(eClass)) {
            DERIVED_ENUMS_MAP.put(eClass, new ArrayList<>());
        }

        DERIVED_ENUMS_MAP.get(eClass).add(this);
    }

    public final int ordinal() {
        return DERIVED_ENUMS_MAP.get(this.getClass()).indexOf(this);
    }

    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static MyEnum[] values(Class<? extends MyEnum> eClass) {
        return DERIVED_ENUMS_MAP.get(eClass).toArray(new MyEnum[0]);
    }

    @Override
    public int compareTo(E that) {
        return this.ordinal() - that.ordinal();
    }

    public static MyEnum valueOf(Class<? extends MyEnum> eClass, String name) {
        for (MyEnum enumConstant : DERIVED_ENUMS_MAP.get(eClass)) {
            if (enumConstant.name.equalsIgnoreCase(name)) {
                return enumConstant;
            }
        }

        return null;
    }
}
