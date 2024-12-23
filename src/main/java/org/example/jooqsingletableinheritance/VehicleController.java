package org.example.jooqsingletableinheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public void addVehicle(@RequestBody Map<String, Object> payload) {
        String type = (String) payload.get("type");
        String manufacturer = (String) payload.get("manufacturer");

        if ("CAR".equalsIgnoreCase(type)) {
            int seatingCapacity = (int) payload.get("seatingCapacity");
            vehicleService.addVehicle(new Car(0, manufacturer, seatingCapacity));
        } else if ("TRUCK".equalsIgnoreCase(type)) {
            int loadCapacity = (int) payload.get("loadCapacity");
            vehicleService.addVehicle(new Truck(0, manufacturer, loadCapacity));
        }
    }
}
