package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajith on 5/29/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override

    public List<Vehicle> loadVehicles(List<Vehicle> vehicles) {

        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList = vehicleRepository.loadVehicles(vehicles);
        if (vehicleList.isEmpty()) {
           /* try {
                throw new Exception("Failed to store data in database ");
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        return vehicleList;
    }
}
