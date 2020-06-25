package com.codegym.cms.service.impl;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.repository.AppUserRepository;
import com.codegym.cms.repository.CustomerRepository;
import com.codegym.cms.repository.ProvinceRepository;
import com.codegym.cms.service.AppUserService;
import com.codegym.cms.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.FileAlreadyExistsException;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) throws Exception {
        Customer newCustomer=
        appUserRepository.findByEmail(customer.getEmail());

        if (newCustomer==null)
        customerRepository.save(customer);
        else {
            throw new FileAlreadyExistsException("email existed!");
        }
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
