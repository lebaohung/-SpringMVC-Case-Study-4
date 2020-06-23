package com.codegym.service.order;

import com.codegym.model.Order;
import com.codegym.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order findbyId(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void save(Order model) {
        orderRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        orderRepository.delete(id);
    }
}
