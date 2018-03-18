package com.shyrokykh.subtask3;

public class Main {
    public static void main(String[] args) {
        MyEnum.init("KEK", "LOL", "KEK"); // prevents duplicates addition

        MyEnum.MyEnumItem kekItem = MyEnum.valueOf("KEK");
        MyEnum.MyEnumItem lolItem = MyEnum.valueOf("LOL");

        System.out.println(kekItem.ordinal());
        System.out.println(kekItem.name());

        for (MyEnum.MyEnumItem myEnumItem : MyEnum.values()) {
            System.out.println(myEnumItem.ordinal());
            System.out.println(myEnumItem.name());
        }

        if (kekItem.compareTo(lolItem) != 0) {
            System.out.println(String.format("%s: %d != %s: %d",
                    kekItem.name(), kekItem.ordinal(), lolItem.name(), lolItem.ordinal()));
        }

        try {
            MyEnum.valueOf("KgEK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MyEnum.MyEnumItem kekItem2 = MyEnum.valueOf("KEK");

        if (kekItem.compareTo(kekItem2) == 0) {
            System.out.println(String.format("%s: %d == %s: %d",
                    kekItem.name(), kekItem.ordinal(), kekItem2.name(), kekItem2.ordinal()));
        }
    }
}
