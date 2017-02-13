package com.room414.homework2.shape.implementation;

import com.room414.homework2.shape.interfaces.Shape;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Parallelogram extends Shape {
    private double width;
    private double height;
    private double angle;

    private Parallelogram(double width, double height, double angle) {
        this.width = width;
        this.height = height;
        this.angle = angle;
    }

    public static Parallelogram createParallelogram(double width, double height, double angle) {
        return new Parallelogram(width, height, angle);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
