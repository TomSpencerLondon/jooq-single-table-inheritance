package org.example.jooqsingletableinheritance;

public class Car extends Vehicle {
    private final int seatingCapacity;

    public Car(int id, String manufacturer, int seatingCapacity) {
        super(id, manufacturer);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
