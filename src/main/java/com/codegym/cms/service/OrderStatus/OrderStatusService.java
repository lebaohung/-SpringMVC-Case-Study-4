package com.codegym.cms.service.OrderStatus;

import com.codegym.cms.model.OrderStatus;
import com.codegym.cms.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStatusService implements IOrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    @Override
    public Iterable<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }
}
