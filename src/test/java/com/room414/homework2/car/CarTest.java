package com.room414.homework2.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
class CarTest {
    @Test
    void go() {
        Wheel[] wheels = new Wheel[] {
            Wheel.createWheel(null, null, 3, 1),
            Wheel.createWheel(null, null, 3, 1),
            Wheel.createWheel(null, null, 3, 1),
            Wheel.createWheel(null, null, 3, 1)
        };

        Car car = Car.carBuilder()
                .setConsumption(1)
                .setTankValue(3)
                .setEngine(Engine.createEngine("", "", 3, 1))
                .setWheels(wheels)
                .createCar();

        int i = 0;

        while (car.go()) {
            i++;
        }

        assert i == 3;
    }

    @Test
    void tankUp() {
        Wheel[] wheels = new Wheel[] {
                Wheel.createWheel(null, null, 3, 1),
                Wheel.createWheel(null, null, 3, 1),
                Wheel.createWheel(null, null, 3, 1),
                Wheel.createWheel(null, null, 3, 1)
        };

        Car car = Car.carBuilder()
                .setConsumption(1)
                .setTankValue(3)
                .setEngine(Engine.createEngine("", "", 3, 1))
                .setWheels(wheels)
                .createCar();

        while (car.go());

        car.tankUp(2);

        assert car.getFuel() == 2;

        assertThrows(IllegalArgumentException.class, () -> car.tankUp(4));
    }
}