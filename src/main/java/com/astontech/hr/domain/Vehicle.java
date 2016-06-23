package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleID")
    private Integer id;

    @Version
    private Integer version;

    private int year;
    private String licensePlate;
    private String vin;
    private String color;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private VehicleModel vehicleModel;

    public Vehicle() {}
    public Vehicle(int year, String licensePlate, String vin, String color) {
        this.setYear(year);
        this.setColor(color);
        this.setLicensePlate(licensePlate);
        this.setVin(vin);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
