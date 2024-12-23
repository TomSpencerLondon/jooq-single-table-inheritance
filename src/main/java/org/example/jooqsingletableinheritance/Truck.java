package org.example.jooqsingletableinheritance;

public class Truck extends Vehicle {
    private final int loadCapacity;

    public Truck(int id, String manufacturer, int loadCapacity) {
        super(id, manufacturer);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}