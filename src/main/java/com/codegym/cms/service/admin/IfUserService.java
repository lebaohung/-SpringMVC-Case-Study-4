package com.codegym.cms.service.admin;

import com.codegym.cms.model.admin.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IfUserService extends IfService<User> {
    Page<User> findAllByNameContaining(String search, Pageable pageable);
    List<User> findAll();
}
