package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ryanmada1 on 6/14/2016.
 */
@Repository
public interface ElementRepository extends CrudRepository<Element, Integer>{

    //will auto generate the requred code from the structure of the method name.
    Element findByElementName (String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);
}
