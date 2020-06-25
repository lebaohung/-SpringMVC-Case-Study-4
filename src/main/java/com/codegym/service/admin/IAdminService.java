package com.codegym.service.admin;

import com.codegym.model.admin.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdminService extends IService<Admin> {
    Page<Admin> findAdminByNameContaining(String name, Pageable pageable);
}
