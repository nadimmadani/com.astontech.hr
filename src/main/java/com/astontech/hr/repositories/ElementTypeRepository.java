package com.astontech.hr.repositories;


import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ryanmada1 on 6/14/2016.
 */

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {
    ElementType findByElementTypeName(String elementType);
    ElementType findByElementTypeNameIgnoreCase(String elementType);
}