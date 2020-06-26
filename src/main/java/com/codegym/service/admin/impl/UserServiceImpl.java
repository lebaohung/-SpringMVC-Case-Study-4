package com.codegym.service.admin.impl;

import com.codegym.model.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.codegym.repository.admin.IUserRepository;
import com.codegym.service.admin.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Page<User> findAllByNameContaining(String search,Pageable pageable) {
        return iUserRepository.findAllByNameContaining(search,pageable);
    }

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findOne(id);
    }

    @Override
    public void save(User model) {
iUserRepository.save(model);
    }

    @Override
    public void remove(Long id) {
iUserRepository.delete(id);
    }
}
