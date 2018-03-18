package com.shyrokykh.subtask3;

import java.util.*;

class MyEnum {
    private static int orderCount = 0;
    private final static Map<String, MyEnumItem> ITEMS = new HashMap<>();

    public static void init(final String... names) {
        for (String name : names) {
            if (!ITEMS.containsKey(name)) {
                ITEMS.put(name, new MyEnumItem(name));
            }
        }
    }

    public static MyEnumItem valueOf(String name) {
        MyEnumItem item = ITEMS.get(name);

        if (item == null) {
            throw new IllegalArgumentException("Enum constant with such name: " + name + " doesn't exist");
        }

        return item;
    }

    public static MyEnumItem[] values() {
        return ITEMS.values().toArray(new MyEnumItem[0]);
    }

    public static class MyEnumItem implements Comparable<MyEnumItem> {
        private final String name;
        private int order;

        private MyEnumItem(String name) {
            if (!ITEMS.containsKey(name)) {
                order = orderCount++;
            }

            this.name = name;
        }

        public final String name() {
            return name;
        }

        public final int ordinal() {
            return order;
        }

        @Override
        public int compareTo(MyEnumItem that) {
            return this.ordinal() - that.ordinal();
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
