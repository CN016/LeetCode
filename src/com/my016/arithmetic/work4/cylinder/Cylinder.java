package com.my016.arithmetic.work4.cylinder;

import com.my016.arithmetic.work4.circle.Circle;
import com.my016.arithmetic.work4.rectangle.Rectangle;
import com.my016.arithmetic.work4.shape.Shape;

public class Cylinder extends Shape {
    private Circle base;
    private Rectangle side;

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.side = new Rectangle(base.getDiameter(), height);
    }

    public double getVolume() {
        return base.getArea() * side.getLength();
    }

    public double getSurfaceArea() {
        return 2 * base.getArea() + side.getArea();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a cylinder...");
    }
}
