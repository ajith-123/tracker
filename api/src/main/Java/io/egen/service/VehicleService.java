package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Ajith on 5/29/2017.
 */
public interface VehicleService {
    List<Vehicle> loadVehicles(List<Vehicle> vehicles);
}
