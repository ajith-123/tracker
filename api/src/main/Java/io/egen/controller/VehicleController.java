package io.egen.controller;

import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajith on 5/29/2017.
 */
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public List<Vehicle> loadVehicles(@RequestBody List<Vehicle> vehicles) {
        vehicleService.loadVehicles(vehicles);
        ArrayList<Vehicle> ar = new ArrayList<Vehicle>();
        return ar;

    }

}
