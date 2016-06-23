package com.astontech.hr.services;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;

/**
 * Created by ryanmada1 on 6/15/2016.
 */
public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType (ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);

    //custom rep methods

    ElementType findByElementTypeName(String elementType);

    ElementType findByElementTypeNameIgnoreCase(String elementType);


}
