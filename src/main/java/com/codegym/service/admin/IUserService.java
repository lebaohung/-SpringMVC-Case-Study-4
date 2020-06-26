package com.codegym.service.admin;

import com.codegym.model.admin.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService extends IService<User> {
    Page<User> findAllByNameContaining(String search, Pageable pageable);
    List<User> findAll();
}
