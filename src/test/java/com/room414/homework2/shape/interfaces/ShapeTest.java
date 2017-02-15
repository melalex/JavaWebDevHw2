package com.room414.homework2.shape.interfaces;

import com.room414.homework2.shape.implementation.Circle;
import com.room414.homework2.shape.implementation.Parallelogram;
import com.room414.homework2.shape.implementation.Trapezium;
import com.room414.homework2.shape.implementation.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
class ShapeTest {
    @Test
    void addition() {
        Circle circle = Circle.createCircle(3);
        Parallelogram parallelogram = Parallelogram.createParallelogram(1, 2, Math.PI / 2);
        Trapezium trapezium = Trapezium.createTrapezium(2, 2, 2);
        Triangle triangle = Triangle.createTriangle(3, 4, 5);
        double cirSumPar1 = circle.addition(parallelogram);
        double traSumTri1 = trapezium.addition(triangle);
        double cirSumTra1 = circle.addition(trapezium);
        double parSumTri1 = parallelogram.addition(triangle);

        double circleArea = circle.getArea();
        double parallelogramArea = parallelogram.getArea();
        double trapeziumArea = trapezium.getArea();
        double triangleArea = triangle.getArea();
        double cirSumPar2 = circleArea + parallelogramArea;
        double traSumTri2 = trapeziumArea + triangleArea;
        double cirSumTra2 = circleArea + trapeziumArea;
        double parSumTri2 = parallelogramArea + triangleArea;

        assert Math.abs(cirSumPar1 - cirSumPar2) <= 0.001;
        assert Math.abs(traSumTri1 - traSumTri2) <= 0.001;
        assert Math.abs(cirSumTra1 - cirSumTra2) <= 0.001;
        assert Math.abs(parSumTri1 - parSumTri2) <= 0.001;
    }

}