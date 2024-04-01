package com.my016.arithmetic.work5;

public abstract class Animal {
    private String name;
    private String time;

     public Animal(String name,String time){
          this.name = name;
          this.time = time;
     }

     public abstract void eat();

     public void showInfo(){
          System.out.println("我是"+this.name+",出生日期:" + this.time);
     }
}
