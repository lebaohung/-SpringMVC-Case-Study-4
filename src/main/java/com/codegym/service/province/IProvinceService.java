package com.codegym.service.province;

import com.codegym.model.Province;

public interface IProvinceService {
    public Iterable<Province> findAll();
    public Province findById(Integer id);
}
