package com.codegym.service.admin;

import com.codegym.model.admin.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IService<Order> {

    Page<Order> findAllByReceiverNameContaining(String search, Pageable pageable);

}
