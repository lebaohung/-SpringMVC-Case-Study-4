package com.codegym.service.OrderStatus;

import com.codegym.model.OrderStatus;
import com.codegym.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStatusService implements IOrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    @Override
    public Iterable<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }
}
