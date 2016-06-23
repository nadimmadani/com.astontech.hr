package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
public interface VehicleModelService {

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    void deleteVehicleModel(Integer id);

    Iterable<VehicleModel> getAllVehicleModel();
}


