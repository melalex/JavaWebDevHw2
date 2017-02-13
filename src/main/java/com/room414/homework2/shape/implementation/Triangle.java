package com.room414.homework2.shape.implementation;

import com.room414.homework2.shape.interfaces.Shape;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    private Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Triangle createTriangle(double a, double b, double c) {

        return new Triangle(a, b, c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
