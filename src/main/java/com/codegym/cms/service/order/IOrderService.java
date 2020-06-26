package com.codegym.cms.service.order;

import com.codegym.cms.model.Order;
import com.codegym.cms.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IService<Order> {
    Page<Order> findAllByCustomerId(Long customerId, Pageable pageable);
}