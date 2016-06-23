package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementServices;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.w3c.dom.html.HTMLDListElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmada1 on 6/15/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ElementServices elementServices;

    @Autowired
    private ElementTypeService elementTypeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateElementAndElementTypes();
    }

    private void generateElementAndElementTypes() {

        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        ElementType phoneType = new ElementType("Phone");

        List<Element> phoneList = new ArrayList<>();
        phoneList.add(new Element("Galaxy"));
        phoneList.add(new Element("Motorola"));
        phoneList.add(new Element("iPhone"));
        phoneList.add(new Element("Nokia"));
        phoneList.add(new Element("Huawei"));

        phoneType.setElementList(phoneList);

        elementTypeService.saveElementType(phoneType);


    }
}
