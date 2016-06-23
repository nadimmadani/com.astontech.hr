package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
@Service
public class VehicleMakeServiceImpl  implements VehicleMakeService{

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findOne(id);
    }

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public void deleteVehicleMake(Integer id) {
        vehicleMakeRepository.delete(id);
    }

    @Override
    public Iterable<VehicleMake> getAllVehicleMake() {
        return vehicleMakeRepository.findAll();
    }
}
