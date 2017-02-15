package com.room414.homework2.car;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class Engine implements Cloneable {
    private String manufacturer;
    private String model;
    private int durability;
    private int durabilityConsumption;

    private Engine(String manufacturer, String model, int durability, int durabilityConsumption) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.durability = durability;
        this.durabilityConsumption = durabilityConsumption;
    }

    public static Engine createEngine(String manufacturer, String model, int durability, int durabilityConsumption) {
        return new Engine(manufacturer, model, durability, durabilityConsumption);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getDurability() {
        return durability;
    }

    boolean tryDamage() {
        return (durability - durabilityConsumption) >= 0;
    }

    void doDamage() {
        durability -= durabilityConsumption;
    }

    public Engine copy() {
        return new Engine(manufacturer, model, durability, durabilityConsumption);
    }
}
