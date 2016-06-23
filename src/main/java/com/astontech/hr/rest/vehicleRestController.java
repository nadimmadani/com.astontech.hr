package com.astontech.hr.rest;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.ElementServices;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ryanmada1 on 6/23/2016.
 */
@RestController
@RequestMapping("/api/vehicles/")
public class vehicleRestController {

    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    ElementServices elementServices;

    @RequestMapping("addmodel/")
    public Iterable<Element> listAllElements(){
        return elementServices.listAllElements();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
        public Element saveElement(@RequestBody Element element) {
        return elementServices.saveElement(element);

    }
}
