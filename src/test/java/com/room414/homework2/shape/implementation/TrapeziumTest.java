package com.room414.homework2.shape.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
class TrapeziumTest {
    @Test
    void getArea() {
        Trapezium trapezium = Trapezium.createTrapezium(2, 2, 2);

        assert Math.abs(trapezium.getArea() - 4) < 0.001;
    }

    @Test
    void createException() {
        assertThrows(IllegalArgumentException.class, () -> Trapezium.createTrapezium(-1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Trapezium.createTrapezium(1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> Trapezium.createTrapezium(1, 1, -1));
        assertThrows(IllegalArgumentException.class, () -> Trapezium.createTrapezium(0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Trapezium.createTrapezium(1, 0, 1));
        assertThrows(IllegalArgumentException.class, () -> Trapezium.createTrapezium(1, 1, 0));
    }

}