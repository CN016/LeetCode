package com.my016.arithmetic;

public class StringDemo {
    public static void main(String[] args) {
        String _1 = "114514";
        String _2 = "114514";

        String _3 = new String("114514");

        Integer t1 = 114514;
        Integer t2 = 114514;
        int     t3 = 114514;

        Integer t4 = 12;
        Integer t5 = 12;

        System.out.println(_3 == _1);

        System.out.println(_2 == _1);

        System.out.println(t1 == t2);
        System.out.println(t1 == t3);
        System.out.println(t4 == t5);
    }
}
