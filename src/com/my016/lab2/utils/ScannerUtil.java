package com.my016.lab2.utils;

import java.util.Scanner;

/**
 * 封装Scanner的常规操作
 */
public class ScannerUtil {

    public static final Scanner _1 = new Scanner(System.in);

    public static String getLine(){
        return _1.nextLine();
    }

    public static Integer getNextInt(){
        return _1.nextInt();
    }

    public static Float getNextFloat(){
        return _1.nextFloat();
    }

    public static Double getNextDouble(){
        return _1.nextDouble();
    }

    public static String getNext(){
        return _1.next();
    }

}
