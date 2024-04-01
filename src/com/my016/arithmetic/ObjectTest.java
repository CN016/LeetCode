package com.my016.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class ObjectTest {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        Object o  = new ObjectTest();
        Object ii = new Object();
        String s ="sdad";
        Integer sd = 213;
        list.add(o);
        list.add(ii);
        list.add(s);
        list.add(sd);
        System.out.println(list);

    }
}
