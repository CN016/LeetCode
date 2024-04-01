package com.my016.arithmetic.learn;

public class Test {
    public static void main(String[] args) {
        //求两个数的均值
        System.out.printf("%.2f\n",Test.getAve(2,3));
        //求三个数的均值
        System.out.printf("%.2f",Test.getAve(2,3,4));
    }
    //请在1、2处补充代码，不允许在其他地方修改或添加代码
    public static double getAve(Integer ... arg) {
        int all = arg.length;
        int sum = 0;
        for (Integer integer : arg) {
            sum+=integer;
        }

        return sum*1.0/all;
    }
}

