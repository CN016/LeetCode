package com.my016.lab4;

public class MyThread{
    private static class T1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("林英茂");
            }

        }
    }
    private static class T2 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("2100300920");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
