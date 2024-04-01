package com.my016.arithmetic.work4;

import com.my016.arithmetic.work4.circle.Circle;
import com.my016.arithmetic.work4.cylinder.Cylinder;
import com.my016.arithmetic.work4.rectangle.Rectangle;

public class APP {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.draw();
        System.out.println("Diameter: " + circle.getDiameter());
        System.out.println("Area: " + circle.getArea());

        Rectangle rectangle = new Rectangle(3.0, 4.0);
        rectangle.draw();
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Area: " + rectangle.getArea());

        Cylinder cylinder = new Cylinder(3.0, 4.0);
        cylinder.draw();
        System.out.println("Volume: " + cylinder.getVolume());
        System.out.println("Surface Area: " + cylinder.getSurfaceArea());
    }
}
