package com.room414.homework2.shape.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
class CircleTest {
    @Test
    void getArea() {
        Circle circle = Circle.createCircle(3);

        assert Math.abs(circle.getArea() - 28.274328) < 0.001;
    }

    @Test
    void createException() {
        assertThrows(IllegalArgumentException.class, () -> Circle.createCircle(-1));
        assertThrows(IllegalArgumentException.class, () -> Circle.createCircle(0));
    }
}