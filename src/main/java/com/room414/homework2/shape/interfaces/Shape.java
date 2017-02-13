package com.room414.homework2.shape.interfaces;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public abstract class Shape {
    public double addition(Shape another) {
        return this.getArea() + another.getArea();
    }

    public abstract double getArea();
}
