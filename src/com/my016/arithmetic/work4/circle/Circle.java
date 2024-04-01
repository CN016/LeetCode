package com.my016.arithmetic.work4.circle;

import com.my016.arithmetic.work4.shape.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle...");
    }
}