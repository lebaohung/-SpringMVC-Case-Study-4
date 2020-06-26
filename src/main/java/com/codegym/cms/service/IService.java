package com.codegym.cms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {
    Page<T> findAll(Pageable pageable);
    T findbyId(Long id);
    void save(T model) throws Exception;
    void remove(Long id);
}