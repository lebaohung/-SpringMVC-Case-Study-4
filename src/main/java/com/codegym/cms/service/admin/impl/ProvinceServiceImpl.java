package com.codegym.cms.service.admin.impl;

import com.codegym.cms.model.admin.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.codegym.cms.repository.admin.IProvinceRepository;
import com.codegym.cms.service.admin.IfProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements IfProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return iProvinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        return iProvinceRepository.findOne(id);
    }

    @Override
    public void save(Province model) {
        iProvinceRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.delete(id);
    }

    @Override
    public Page<Province> findAllByNameContaining(String search, Pageable pageable) {
        return iProvinceRepository.findAllByNameContaining(search,pageable);
    }
}
