package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.AppUserRepository;
import com.codegym.cms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.file.FileAlreadyExistsException;

public class CustomerService implements ICustomerService {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findbyId(Long id) {
        return customerRepository.findOne(id);
    }


    @Override
    public void save(Customer customer) throws Exception {
        Customer newCustomer =
                appUserRepository.findByEmail(customer.getEmail());

        if (newCustomer == null)
            customerRepository.save(customer);
        else {
            throw new FileAlreadyExistsException("email existed!");
        }
    }

    @Override
    public void remove(Long id) {

    }
}