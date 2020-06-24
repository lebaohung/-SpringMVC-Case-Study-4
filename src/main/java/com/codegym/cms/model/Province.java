package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Province {
    @Id
    @GeneratedValue
    private Integer provinceId;
    private String name;
    private float position;

//    @OneToMany(targetEntity = com.codegym.model.Order.class)
//    private List<com.codegym.model.Order> orderList;

    public Province() {
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

//    public List<com.codegym.model.Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<com.codegym.model.Order> orderList) {
//        this.orderList = orderList;
//    }
}
