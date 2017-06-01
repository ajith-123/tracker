package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajith on 5/30/2017.
 */
@Repository

public class VehicleRepositoryImpl implements VehicleRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
@Transactional
    public List<Vehicle> loadVehicles(List<Vehicle> vehicles) {




List<Vehicle> vehicleList = new ArrayList<Vehicle>();


       for ( Vehicle vehicle:vehicles) {
           Vehicle veh = findVehicleByVIN(vehicle.getVin());

if(veh==null) {
    vehicleList.add(insertVehicle(vehicle));
    //System.out.println(" creating new vale!!!");
}
else {
   // System.out.println(" going to update!!!");
    vehicleList.add(updateVehicle(vehicle));

}
        }




        return vehicleList;
    }

    @Override
    public Vehicle findVehicleByVIN(String vin)
    {
        return em.find(Vehicle.class,vin);
    }


    public Vehicle insertVehicle(Vehicle vehicle)
    {

        em.persist(vehicle);
        return vehicle;
    }
    public Vehicle updateVehicle(Vehicle vehicle)
    {
        em.merge(vehicle);
        return vehicle;
    }
}
