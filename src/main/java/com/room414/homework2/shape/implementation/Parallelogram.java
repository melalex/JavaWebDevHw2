package com.room414.homework2.shape.implementation;

import com.room414.homework2.shape.interfaces.Shape;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Parallelogram extends Shape {
    private double aSide;
    private double bSide;
    private double angle;

    private Parallelogram(double aSide, double bSide, double angle) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.angle = angle;
    }

    public static Parallelogram createParallelogram(double aSide, double bSide, double angle) {
        if (angle <= 0 || angle >= Math.PI) {
            throw new IllegalArgumentException(String.format(
                    "angle should be in range (0; %s). Got %s.", Math.PI, angle
            ));
        }

        if (aSide <= 0 || bSide <= 0) {
            throw new IllegalArgumentException("Side can't be <= 0");
        }

        return new Parallelogram(aSide, bSide, angle);
    }

    public double getASide() {
        return aSide;
    }

    public double getBSide() {
        return bSide;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public double getArea() {
        return aSide * bSide * Math.sin(angle);
    }
}
