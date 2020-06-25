package com.codegym.model.admin;

import javax.persistence.*;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float intraProvince;
    private float interRegion;
    public Price(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getIntraProvince() {
        return intraProvince;
    }

    public void setIntraProvince(float intraProvince) {
        this.intraProvince = intraProvince;
    }

    public float getInterRegion() {
        return interRegion;
    }

    public void setInterRegion(float interRegion) {
        this.interRegion = interRegion;
    }

    public Price(Long id, float intraProvince, float interRegion) {
        this.id = id;
        this.intraProvince = intraProvince;
        this.interRegion = interRegion;
    }
}
