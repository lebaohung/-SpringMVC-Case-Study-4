package com.codegym.cms.model.admin;

import javax.persistence.*;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float position;
    public Province(){}

    public Province(Long id, String name, float position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void setPosition(float position) {
        this.position = position;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPosition() {
        return position;
    }

    public void setPosition(Float position) {
        this.position = position;
    }


}
