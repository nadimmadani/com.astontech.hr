package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

import java.util.List;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
public interface VehicleMakeService {


    VehicleMake getVehicleMakeById(Integer id);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    void deleteVehicleMake(Integer id);

    Iterable<VehicleMake> getAllVehicleMake();
}
