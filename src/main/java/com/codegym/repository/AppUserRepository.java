package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
}
