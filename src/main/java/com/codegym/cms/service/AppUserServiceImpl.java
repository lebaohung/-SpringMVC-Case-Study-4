package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public Customer getUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer user = this.getUserByEmail(email);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getRole());

        UserDetails userDetails = new User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );

        return userDetails;
    }
}
