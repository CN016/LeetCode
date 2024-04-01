package com.my016.arithmetic.work5;

public class Horse extends Animal{

    public Horse(String name, String time){
        super(name,time);
    }


    public void run(){
        System.out.println("我在奔跑");
    }

    @Override
    public void eat(){
        System.out.println("我在吃草");
    }
}
