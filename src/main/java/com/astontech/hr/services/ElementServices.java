package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.List;

/**
 * Created by ryanmada1 on 6/15/2016.
 */
public interface ElementServices {

    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);


    //custom repo methods

    Element findByElementName (String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);
}
