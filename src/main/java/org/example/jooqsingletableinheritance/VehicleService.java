package org.example.jooqsingletableinheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAllVehicles();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.insertVehicle(vehicle);
    }
}
