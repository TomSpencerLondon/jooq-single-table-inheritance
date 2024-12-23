package org.example.jooqsingletableinheritance;

public abstract class Vehicle {
    private final int id;
    private final String manufacturer;

    public Vehicle(int id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}