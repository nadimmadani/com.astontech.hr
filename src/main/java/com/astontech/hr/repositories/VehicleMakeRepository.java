package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
@Repository
public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer>{


}
