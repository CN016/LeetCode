package com.my016.arithmetic.learn;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

public class RamdonArray {
    public static void main(String[] args) {
        int[] a = {1,1,4,5,1,4,1,9,1,9,8,1,0};
        float[] b = {1,1,4,5,1,4,1,9,1,9,8,1,0};
        double[] c = {1,1,4,5,1,4,1,9,1,9,8,1,0};
        short[] d = {1,1,4,5,1,4,1,9,1,9,8,1,0};

        System.out.println("a:" + Arrays.toString(a));
        System.out.println("b:"+ Arrays.toString(b));
        System.out.println("c:"+ Arrays.toString(c));
        System.out.println("d:"+ Arrays.toString(d));

        ramdonArray(a);
        ramdonArray(b);
        ramdonArray(c);
        ramdonArray(d);

        System.out.println("a:" + Arrays.toString(a));
        System.out.println("b:"+ Arrays.toString(b));
        System.out.println("c:"+ Arrays.toString(c));
        System.out.println("d:"+ Arrays.toString(d));
    }

    public static void ramdonArray(int[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static void ramdonArray(short[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            short t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static void ramdonArray(float[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            float t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static void ramdonArray(double[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            double t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

}
