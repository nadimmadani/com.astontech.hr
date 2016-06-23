package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ryanmada1 on 6/14/2016.
 */
@Entity
public class ElementType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ElementTypeID")
    private Integer id;

    @Version
    private Integer version;

    private String elementTypeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Element> elementList;

    public ElementType() {}
    public ElementType(String elementTypeName) {
        this.setElementTypeName(elementTypeName);
    }
    public ElementType(String elementTypeName, List<Element> elementList) {
        this.setElementTypeName(elementTypeName);
        this.setElementList(elementList);
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

    public String getElementTypeName() {
        return elementTypeName;
    }

    public void setElementTypeName(String elementTypeName) {
        this.elementTypeName = elementTypeName;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
}
