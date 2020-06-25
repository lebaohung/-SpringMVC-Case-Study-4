package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Order;
import com.codegym.cms.model.Province;

import java.util.Optional;


public interface OrderService {
    Iterable<Order> findAllByUser(Customer user);

    Iterable<Order> findAll();

    Optional<Order> findById(Long id);

    void save(Order order);

    void remove(Long id);
}
