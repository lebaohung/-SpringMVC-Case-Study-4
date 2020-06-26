package com.codegym.cms.repository.admin;

import com.codegym.cms.model.admin.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
    Page<Province> findAllByNameContaining(String search, Pageable pageable);

    List<Province> findAll();
}

