package com.astontech.hr.domain.VO;

/**
 * Created by ryanmada1 on 6/16/2016.
 */
public class ElementVO {

    private String newElementType;
    private String newElement;
    private String[] newElementArray;

    public ElementVO() {}

    //region CUSTOM METHODS

    //regex for splitting on a new line or a carriage return is "\\r?\n"
    public void splitNewElementsIntoArray() {
        this.setNewElementArray(this.newElement.split(("\\r?\n")));

    }
    //endregion



    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElement() {
        return newElement;
    }

    public void setNewElement(String newElement) {
        this.newElement = newElement;
    }

    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }
}
