package com.my016.arithmetic.work4.rectangle;

import com.my016.arithmetic.work4.shape.Shape;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return width * length;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle...");
    }
}