package com.codegym.service.OrderStatus;

import com.codegym.model.OrderStatus;

public interface IOrderStatusService {
    public Iterable<OrderStatus> findAll();
}
