package com.codegym.cms.service;

//import com.codegym.cms.model.AppUser;
import com.codegym.cms.model.Customer;

public interface AppUserService {
    Customer getUserByEmail(String username);
}
