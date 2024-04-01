package com.my016.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class GameOf3 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1,2,3");
        strings.add("1,3,2");
        strings.add("2,1,3");
        System.out.println(strings.toString());
    }
}
