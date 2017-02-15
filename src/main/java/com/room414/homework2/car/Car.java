package com.room414.homework2.car;

import java.util.Arrays;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Car {
    private static int WHEEL_COUNT = 4;

    private String manufacturer;
    private String model;
    private Wheel[] wheels;
    private Engine engine;
    private int consumption;
    private int tankValue;
    private int fuel;

    public static class CarBuilder {
        private String manufacturer;
        private String model;
        private Wheel[] wheels;
        private Engine engine;
        private int consumption;
        private int tankValue;

        private CarBuilder() {

        }

        public CarBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setWheels(Wheel[] wheels) {
            if (wheels.length != WHEEL_COUNT) {
                throw new IllegalArgumentException();
            }

            this.wheels = wheels;
            return this;
        }

        public CarBuilder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setConsumption(int consumption) {
            if (consumption <= 0) {
                throw new IllegalArgumentException();
            }

            this.consumption = consumption;
            return this;
        }

        public CarBuilder setTankValue(int tankValue) {
            if (tankValue <= 0) {
                throw new IllegalArgumentException();
            }

            this.tankValue = tankValue;
            return this;
        }

        public Car createCar() {
            return new Car(manufacturer, model, wheels, engine, consumption, tankValue);
        }
    }

    private Car(String manufacturer, String model, Wheel[] wheels, Engine engine, int consumption, int tankValue) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.wheels = wheels;
        this.engine = engine;
        this.consumption = consumption;
        this.tankValue = tankValue;

        fuel = tankValue;
    }

    public static CarBuilder carBuilder() {
        return new CarBuilder();
    }

    public boolean go() {
        if (fuel - consumption < 0) {
            return false;
        }

        if (engine.tryDamage()) {
            return false;
        }

        if (!Arrays.stream(wheels).allMatch(Wheel::tryDamage)) {
            return false;
        }

        fuel -= consumption;
        engine.doDamage();
        Arrays.stream(wheels).forEach(Wheel::doDamage);

        return true;
    }

    public void tankUp(int fuel) {
        if (this.fuel + fuel > tankValue) {
            throw new IllegalArgumentException();
        }

        this.fuel += fuel;
    }

    public void changeWheel(Wheel wheel, int number) {
        if (number >= WHEEL_COUNT - 1 || number < 0) {
            throw new IllegalArgumentException();
        }

        wheels[number] = wheel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Wheel[] getWheels() {
        return wheels.clone();
    }

    public Engine getEngine() {
        return engine.copy();
    }

    public void setEngine(Engine engine) {
        this.engine = engine.copy();
    }

    public int getConsumption() {
        return consumption;
    }

    public int getTankValue() {
        return tankValue;
    }

    public int getFuel() {
        return fuel;
    }
}
