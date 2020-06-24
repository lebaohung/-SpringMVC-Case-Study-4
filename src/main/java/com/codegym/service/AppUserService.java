package com.codegym.service;

import com.codegym.model.Customer;

public interface AppUserService {
    Customer getUserByEmail(String email);
}
