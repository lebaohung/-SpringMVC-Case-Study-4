package com.codegym.service.order;

import com.codegym.model.Order;
import com.codegym.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IService<Order> {
    Page<Order> findAllByCustomerId(Long customerId, Pageable pageable);
}
