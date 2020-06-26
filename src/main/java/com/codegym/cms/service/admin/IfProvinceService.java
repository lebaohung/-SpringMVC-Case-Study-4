package com.codegym.cms.service.admin;

import com.codegym.cms.model.admin.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IfProvinceService extends IfService<Province> {
    Page<Province> findAllByNameContaining(String search, Pageable pageable);
    List<Province> findAll();
}
