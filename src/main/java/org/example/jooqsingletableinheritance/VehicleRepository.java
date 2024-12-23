package org.example.jooqsingletableinheritance;

import com.example.jooq.generated.Tables;
import com.example.jooq.generated.tables.records.VehicleRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository {
    private final DSLContext dsl;

    @Autowired
    public VehicleRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Vehicle> findAllVehicles() {
        return dsl.selectFrom(Tables.VEHICLE)
                  .fetch(this::mapRecordToVehicle);
    }

    private Vehicle mapRecordToVehicle(VehicleRecord record) {
        String type = record.getType();

        switch (type) {
            case "CAR":
                return new Car(
                    record.getId(),
                    record.getManufacturer(),
                    record.getSeatingCapacity()
                );
            case "TRUCK":
                return new Truck(
                    record.getId(),
                    record.getManufacturer(),
                    record.getLoadCapacity()
                );
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public void insertVehicle(Vehicle vehicle) {
        if (vehicle instanceof Car car) {
            dsl.insertInto(Tables.VEHICLE)
                    .set(Tables.VEHICLE.TYPE, "CAR")
                    .set(Tables.VEHICLE.MANUFACTURER, car.getManufacturer())
                    .set(Tables.VEHICLE.SEATING_CAPACITY, car.getSeatingCapacity())
                    .execute();
        } else if (vehicle instanceof Truck truck) {
            dsl.insertInto(Tables.VEHICLE)
                    .set(Tables.VEHICLE.TYPE, "TRUCK")
                    .set(Tables.VEHICLE.MANUFACTURER, truck.getManufacturer())
                    .set(Tables.VEHICLE.LOAD_CAPACITY, truck.getLoadCapacity())
                    .execute();
        }
    }
}