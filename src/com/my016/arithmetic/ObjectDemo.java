package com.my016.arithmetic;

public class ObjectDemo {
    public static void main(String[] args) {
        D d  = new D();
        System.out.println(d);
    }
}class D{
    @Override
    public String toString() {
        return "我是D对象，我爱举哥";
    }
}
