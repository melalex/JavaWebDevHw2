package com.room414.homework2.shape.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
class TriangleTest {
    @Test
    void getArea() {
        Triangle triangle = Triangle.createTriangle(3, 4, 5);

        assert Math.abs(triangle.getArea() - 6) <= 0.001;
    }

    @Test
    void createException() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(-1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(1, 1, -1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(1, 0, 1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(1, 1, 0));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(17, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(1, 17, 1));
        assertThrows(IllegalArgumentException.class, () -> Triangle.createTriangle(1, 1, 17));
    }
}