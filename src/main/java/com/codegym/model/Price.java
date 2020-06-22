package com.codegym.model;

import javax.persistence.*;

@Table
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;
    private float intraProvince;
    private float interRegion;

    public Price() {
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
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
}
