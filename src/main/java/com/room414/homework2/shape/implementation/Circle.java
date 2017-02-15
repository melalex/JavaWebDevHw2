package com.room414.homework2.shape.implementation;

import com.room414.homework2.shape.interfaces.Shape;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Circle extends Shape {
    private double radius;

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle createCircle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius can't be <= 0");
        }

        return new Circle(radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
