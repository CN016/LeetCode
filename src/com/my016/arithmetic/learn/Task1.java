package com.my016.arithmetic.learn;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[]args){
        int k=10;
        int k1=k<<2;
        int k2=k>>2;
        System.out.println(k1);
        System.out.println(k2);
        int x =10;
        double y =x;
        byte a = (byte) 0x89;
        System.out.println("www.educoder.net");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入嫦娥个人信息：");
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入年龄：");
        String age = scanner.next();
        System.out.println("请输入性别：");
        String sex = scanner.next();
        System.out.println("请输入体重：");
        String tiz = scanner.next();
        System.out.println("请输入地址：");
        String add = scanner.next();
        System.out.println("请输入是否已婚：");
        String is = scanner.next();
        System.out.println("信息如下：");
        System.out.println(   "姓名："+name);
        System.out.println(   "年龄：" +age);
        System.out.println(   "性别：" +sex);
        System.out.println(   "体重：" +tiz);
        System.out.println(   "地址：" +add);
        System.out.println(      "婚否："+is);

        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("N="+Arrays.toString(arr));
    }
}
