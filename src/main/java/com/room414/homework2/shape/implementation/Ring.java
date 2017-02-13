package com.room414.homework2.shape.implementation;

import com.room414.homework2.shape.interfaces.Shape;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Ring extends Shape {
    private double radius;

    public Ring(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }
}
