package com.codegym.cms.service.province;

import com.codegym.cms.model.Province;

public interface IProvinceService {
    public Iterable<Province> findAll();
    public Province findById(Integer id);
}