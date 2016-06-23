package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;

/**
 * Created by ryanmada1 on 6/20/2016.
 */
public class VehiclesVO {

    private String newVehicleModelName;
    private String newVehicleMakeName;
    private String[] newVehicleList;
    private String newVehicleColor;
    private String newVehicleYear;
    private String newVehicleLicensePlate;
    private String newVehicleVin;
    private VehicleModel newVehicleModel;


    public String getNewVehicleModelName() {
        return newVehicleModelName;
    }

    public void setNewVehicleModelName(String newVehicleModelName) {
        this.newVehicleModelName = newVehicleModelName;
    }

    public String getNewVehicleMakeName() {
        return newVehicleMakeName;
    }

    public void setNewVehicleMakeName(String newVehicleMakeName) {
        this.newVehicleMakeName = newVehicleMakeName;
    }

    public String[] getNewVehicleList() {
        return newVehicleList;
    }

    public void setNewVehicleList(String[] newVehicleList) {
        this.newVehicleList = newVehicleList;
    }

    public String getNewVehicleColor() {
        return newVehicleColor;
    }

    public void setNewVehicleColor(String newVehicleColor) {
        this.newVehicleColor = newVehicleColor;
    }

    public String getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(String newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleVin() {
        return newVehicleVin;
    }

    public void setNewVehicleVin(String newVehicleVin) {
        this.newVehicleVin = newVehicleVin;
    }

    public VehicleModel getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(VehicleModel newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

}
