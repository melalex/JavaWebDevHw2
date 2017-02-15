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
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Side can't be <= 0");
        }

        if (!(a + b > c) || !(b + c > a) || !(a + c > b)) {
            throw new IllegalArgumentException(String.format(
                    "Triangle with sides %s, %s, %s doesn't exist.", a, b, c
            ));
        }
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
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
