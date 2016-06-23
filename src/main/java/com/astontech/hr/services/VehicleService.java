package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
public interface VehicleService {

    Iterable<Vehicle> listAllVehicle();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehiclelist(Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);

}
