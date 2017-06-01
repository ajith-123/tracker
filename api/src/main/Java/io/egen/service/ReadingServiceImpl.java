package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Priority;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajith on 5/29/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    private ReadingRepository readingRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private AlertService alertService;

    @Override
    public Reading insertReading(Reading reading) throws Exception {

        Reading reading_vehicle = new Reading();
        reading_vehicle = readingRepository.insertReading(reading);
        if (reading_vehicle == null) {
            throw new Exception("Could not store reading check value!");
        }

        List<Alert> alerts = comparison_vehicleReading(vehicleRepository.findVehicleByVIN(reading_vehicle.getVin()), reading_vehicle);

        alertService.insertAlertList(alerts);
        return reading_vehicle;
    }


    List<Alert> comparison_vehicleReading(Vehicle vehicle, Reading reading) {
        List<Alert> alerts = new ArrayList<Alert>();
        if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("EngineRpm is exceeding Vehicle redLineRpm");
            alert.setPriority(Priority.HIGH);
            alerts.add(alert);
        }
        if (reading.getFuelVolume() < (0.10) * vehicle.getMaxFuelVolume()) {
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("FuelVolume is less than  10% of Vehicle maxFuelVolume");
            alert.setPriority(Priority.MEDIUM);
            alerts.add(alert);
        }
        if (reading.isEngineCoolantLow() == true || reading.isCheckEngineLightOn() == true) {
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("engine coolant is low or engine light is on ");
            alert.setPriority(Priority.LOW);
            alerts.add(alert);

        }
        if (reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontLeft() > 36) {
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("Front left Tire pressure is not in range");
            alert.setPriority(Priority.LOW);
            alerts.add(alert);
        }
        if (reading.getTires().getFrontRight() < 32 || reading.getTires().getFrontRight() > 36) {


            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("Front Right Tire pressure is not in range");
            alert.setPriority(Priority.LOW);
            alerts.add(alert);
        }
        if (reading.getTires().getRearLeft() < 32 || reading.getTires().getRearLeft() > 36) {

            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("Rear left Tire pressure is not in range");
            alert.setPriority(Priority.LOW);
            alerts.add(alert);
        }
        if (reading.getTires().getRearRight() < 32 || reading.getTires().getRearRight() > 36) {


            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setTimeStamp(reading.getTimestamp());
            alert.setMessage("Rear Right Tire pressure is not in range");
            alert.setPriority(Priority.LOW);
            alerts.add(alert);
        }
        return alerts;
    }
}