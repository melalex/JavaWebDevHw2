package com.room414.homework2.shape.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
class ParallelogramTest {
    @Test
    void getArea() {
        Parallelogram parallelogram = Parallelogram.createParallelogram(1, 2, Math.PI / 2);

        assert Math.abs(parallelogram.getArea() - 2) < 0.001;
    }

    @Test
    void createException() {
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(-1, 2, Math.PI / 2));
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(1, -2, Math.PI / 2));
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(0, 2, Math.PI / 2));
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(1, 0, Math.PI / 2));
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(1, 1, 45));
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(1, 1, 0));
        assertThrows(IllegalArgumentException.class, () -> Parallelogram.createParallelogram(1, 1, -1));
    }
}