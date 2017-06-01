package io.egen.repository;

import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Ajith on 5/30/2017.
 */
public interface VehicleRepository {


    List<Vehicle> loadVehicles(List<Vehicle> vehicles);

    Vehicle findVehicleByVIN(String vin);
}
