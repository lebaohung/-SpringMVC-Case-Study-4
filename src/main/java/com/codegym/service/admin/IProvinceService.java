package com.codegym.service.admin;

import com.codegym.model.admin.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProvinceService extends IService<Province> {
    Page<Province> findAllByNameContaining(String search, Pageable pageable);
    List<Province> findAll();
}
