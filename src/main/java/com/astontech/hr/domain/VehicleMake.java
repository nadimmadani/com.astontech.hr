package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
@Entity
public class VehicleMake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleMakeID")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleMakeName;

    public VehicleMake() {}

    public VehicleMake(String vehicleMakeName) {
        this.setVehicleMakeName(vehicleMakeName);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }
}


