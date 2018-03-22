package com.shyrokykh.subtask3;

import com.shyrokykh.subtask3.enums.Colors;
import com.shyrokykh.subtask3.enums.MyEnum;
import com.shyrokykh.subtask3.enums.Size;

public class Main {
    public static void main(String[] args) {
        System.out.println(Colors.BLACK);
        System.out.println(Size.LARGE);

        for (MyEnum enumConstant : MyEnum.values(Colors.class)) {
            System.out.println(String.format("%d: %s", enumConstant.ordinal(), enumConstant.getName()));
        }

        for (MyEnum enumConstant : MyEnum.values(Size.class)) {
            System.out.println(String.format("%d: %s", enumConstant.ordinal(), enumConstant.getName()));
        }

        System.out.println(Colors.RED.compareTo(Colors.BLACK));
        System.out.println(Size.LARGE.compareTo(Size.MIDDLE));
    }
}
