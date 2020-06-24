package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
}
