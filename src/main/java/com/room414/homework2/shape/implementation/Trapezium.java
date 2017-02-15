package com.room414.homework2.shape.implementation;

import com.room414.homework2.shape.interfaces.Shape;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Trapezium extends Shape {
    private double a;
    private double b;
    private double h;

    private Trapezium(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public static Trapezium createTrapezium(double a, double b, double h) {
        if (a <= 0 || b <= 0 || h <= 0) {
            throw new IllegalArgumentException("Argument can't be <= 0");
        }

        return new Trapezium(a, b, h);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return h;
    }

    @Override
    public double getArea() {
        return (a + b) * h / 2;
    }
}
