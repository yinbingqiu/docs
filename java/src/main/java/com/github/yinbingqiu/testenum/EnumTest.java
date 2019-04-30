package com.github.yinbingqiu.testenum;

import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @description:测试枚举
 * @author: yinbing.qiu
 * @create: 2019-04-30 17:07:53
 */
public class EnumTest {
    /**
     * toString ONE
     * name ONE
     * ordinal 0
     * --------------------
     * toString TWO
     * name TWO
     * ordinal 1
     * --------------------
     * toString THREE
     * name THREE
     * ordinal 2
     * --------------------
     */
    @Test
    public void testEnumSet() {
        EnumSet<MyEnum> enumSet = EnumSet.allOf(MyEnum.class);

        for (MyEnum myEnum : enumSet) {
            System.out.println("toString " + myEnum);
            System.out.println("name " + myEnum.name());
            System.out.println("ordinal " + myEnum.ordinal());
            System.out.println("--------------------");
        }
    }


    @Test
    public void testEnumMap() {
        EnumMap<MyEnum, Integer> enumMap = new EnumMap<>(MyEnum.class);
        enumMap.put(MyEnum.ONE, 1);
        enumMap.put(MyEnum.TWO, 2);
        enumMap.put(MyEnum.THREE, 3);

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
        enumMap.forEach((k, v) -> System.out.println("k:" + k + " v:" + v));
    }

    enum MyEnum {
        ONE, TWO, THREE
    }
}
