package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehiclesVO;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmada1 on 6/16/2016.
 */
@Controller
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;


    private Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {
        return "admin/adminHome";

    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert","visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String admin(ElementVO elementVO, Model model){
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        saveElementTypeandElementsFromVO(elementVO);

        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model) {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());
        return "admin/element/element_list";

    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType, Model model,
                                                                        @RequestParam("inputNewElement") String newElement) {
        //notes:        if newElement (unbound text box) has a value, add it to the list
        if(!newElement.equals("")) {
            if(elementType.getElementList() == null) {
                List<Element> elementList = new ArrayList<>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            } else {
                elementType.getElementList().add(new Element(newElement));
            }
        }
        //notes:    iterate through the list of elements
        for(int i = 0; i < elementType.getElementList().size(); i++) {
            //check to see if element name is empty
            if(elementType.getElementList().get(i).getElementName().equals("")) {
                //notes:    if element name is blank remove it from the list
                elementType.getElementList().remove(i);
            }
        }
        elementTypeService.saveElementType(elementType);

        return "redirect:/admin/element/edit/" +elementType.getId();
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);

        return "redirect:/admin/element/list/";
    }

    //ADMIN VEHICLE

    @RequestMapping(value="/admin/vehicles/addmake", method = RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vehiclesVo", new VehiclesVO());

        return "/admin/vehicles/vehicles_add";
    }

    @RequestMapping(value = "/admin/vehicles/addmake", method = RequestMethod.POST)
    public String adminAddVehicleMake(VehiclesVO vehicleVo, Model model) {
        log.info("New Element Type: " + vehicleVo.getNewVehicleMakeName());

        VehicleModel newVehicleModel = new VehicleModel(vehicleVo.getNewVehicleModelName());

        VehicleMake newVehicleMake = new VehicleMake(vehicleVo.getNewVehicleMakeName());

        newVehicleModel.setVehicleMake(newVehicleMake);

        vehicleModelService.saveVehicleModel(newVehicleModel);
        vehicleMakeService.saveVehicleMake(newVehicleMake);

        model.addAttribute("vehiclesVo", new VehiclesVO());

        return "/admin/vehicles/vehicles_add";
    }

    @RequestMapping(value = "/admin/vehicles/addmodel", method = RequestMethod.GET)
    public String adminAddVehicleModel(VehiclesVO vehiclesVo, Model model) {

        model.addAttribute("vehicleMakeList", vehicleMakeService.getAllVehicleMake());
        model.addAttribute("vehiclesVo", new VehiclesVO());

        return "/admin/vehicles/vehicles_addmodel";
    }

    @RequestMapping(value = "/admin/vehicles/addmodel", method = RequestMethod.POST)
    public String adminVehicleModelPost(VehiclesVO vehiclesVO, Model model) {
        VehicleModel newVehicleModel = new VehicleModel(vehiclesVO.getNewVehicleModelName());
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(vehiclesVO.getNewVehicleModel().getVehicleMake().getId());
        newVehicleModel.setVehicleMake(vehicleMake);

        vehicleModelService.saveVehicleModel(newVehicleModel);

        return "redirect:/admin/vehicles/addmodel";
    }

    @RequestMapping(value = "/admin/vehicles/addvehicle", method = RequestMethod.GET)
    public String adminAddVehicleGet(VehiclesVO vehiclesVO, Model model) {

        model.addAttribute("vehicleMakeList", vehicleMakeService.getAllVehicleMake());
        model.addAttribute("vehicleModelList", vehicleModelService.getAllVehicleModel());
        model.addAttribute("vehiclesVO", new VehiclesVO());

        return "/admin/vehicles/vehicles_addvehicle";
    }

    @RequestMapping(value = "/admin/vehicles/addvehicle", method = RequestMethod.POST)
    public String adminAddVehiclePost(VehiclesVO vehiclesVO, Model model) {

        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(vehiclesVO.getNewVehicleModel().getVehicleMake().getId());
        VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(vehiclesVO.getNewVehicleModel().getId());

        Vehicle newVehicle = new Vehicle();

        newVehicle.setVin(vehiclesVO.getNewVehicleVin());
        newVehicle.setLicensePlate(vehiclesVO.getNewVehicleLicensePlate());
        newVehicle.setColor(vehiclesVO.getNewVehicleColor());
        newVehicle.setYear(Integer.parseInt(vehiclesVO.getNewVehicleYear()));
        newVehicle.setVehicleModel(vehicleModel);

        vehicleService.saveVehicle(newVehicle);

        return "redirect:/admin/vehicles/addvehicle";
    }

    @RequestMapping(value = "/admin/vehicles/vehicleslist", method = RequestMethod.GET)
    public String adminVehicleListGet(VehiclesVO vehiclesVO, Model model) {
        model.addAttribute("vehicleMakeList", vehicleMakeService.getAllVehicleMake());
        model.addAttribute("vehicleModelList", vehicleModelService.getAllVehicleModel());
        model.addAttribute("newVehicleList", vehicleService.listAllVehicle());

        return "admin/vehicles/vehicles_list";
    }

//    @RequestMapping(value = "/admin/vehicle/updatevehicle", method = RequestMethod.POST)
//    public String vehicleUpdate(Vehicle vehicleModel, Model model) {
//
//        Vehicle vehicle = vehicleService.getVehicleById(vehicleModel.getId());
//
//        vehicleService.saveVehicle(vehicle);
//        return "redirect:/admin/vehicles/vehicleslist/";
//    }






    //region HELPER METHODS

    private void logElementVO(ElementVO elementVO){
        log.info("New Element Type: " + elementVO.getNewElementType());


        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: "  +  str);
        }
        log.info("New Elements: " + elementVO.getNewElement());
    }

    private void saveElementTypeandElementsFromVO(ElementVO elementVO) {
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);
    }

    //endregion
}
