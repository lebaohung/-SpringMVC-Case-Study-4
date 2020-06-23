package com.codegym.service.province;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceService implements IProvinceService{

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Province findById(Integer id) {
        return provinceRepository.findOne(id);
    }
}
