package com.codegym.service.user;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User findbyId(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User model) {
        userRepository.save(model);
    }

    @Override
    public void remove(Long id) {

    }
}
