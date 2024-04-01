package com.my016.arithmetic.learn;

import java.util.Scanner;

public class MyNumber {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public MyNumber(Integer number) {
        this.number = number;
    }

    public static void swap(MyNumber o1, MyNumber o2){
        Integer temp = o1.getNumber();
        o1.setNumber(o2.getNumber());
        o2.setNumber(temp);
    }

    private static class Main{
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc=new Scanner(System.in);
            int a1=sc.nextInt();
            int b1=sc.nextInt();
            MyNumber numA=new MyNumber(a1);
            MyNumber numB=new MyNumber(b1);
            System.out.printf("a1=%d,b1=%d\n",numA.getNumber(),numB.getNumber());
            MyNumber.swap(numA,numB);
            System.out.printf("a1=%d,b1=%d", numA.getNumber(),numB.getNumber());
            sc.close();
        }
    }
}
