package com.my016.arithmetic.work5;

public class Goldfish extends Animal{
    public Goldfish(String name,String time){
        super(name,time);
    }

    @Override
    public void eat() {
        System.out.println("我在吃合适鱼的食物");
    }

    public void swim(){
        System.out.println("我在游泳");
    }
}
