package com.codegym.cms.service.OrderStatus;

import com.codegym.cms.model.OrderStatus;

public interface IOrderStatusService {
    public Iterable<OrderStatus> findAll();
}
