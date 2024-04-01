package com.my016.lab2;

import java.util.Random;

public class Image {
    private final int[][] R;
    private final int[][] G;
    private final int[][] B;
    private final int wide;
    private final int high;

    public Image(int wide,int high){
        this.high = high;
        this.wide = wide;
        this.R = new int[high][wide];
        this.G = new int[high][wide];
        this.B = new int[high][wide];
        init();
    }

    public void printRGB(){
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                System.out.println("RGB:("+R[i][j]+','+G[i][j]+','+B[i][j]+')');
            }
        }
    }

    private void init() {
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                R[i][j] = r.nextInt(256);
                G[i][j] = r.nextInt(256);
                B[i][j] = r.nextInt(256);
            }
        }
    }

    private static class Main{
        public static void main(String[] args) {
            Image image = new Image(10,10);
            image.printRGB();
        }
    }
}
