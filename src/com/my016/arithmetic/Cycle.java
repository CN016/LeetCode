package com.my016.arithmetic;

public class Cycle {

    private static final double PI = Math.PI;

    private final double radius;

    public Cycle(double radius){
        this.radius = radius;
    }

    public void calculationArea(){
        System.out.println(PI*radius*radius);
    }
}class TestMain{
    public static void main(String[] args) {
        Cycle cycle = new Cycle(3);
        cycle.calculationArea();
    }
}
