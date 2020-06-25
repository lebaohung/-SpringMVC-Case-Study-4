package com.codegym.service.admin;

import com.codegym.model.admin.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IService<Order> {
    Page<Order> findAllByOrderIdContaining(String search, Pageable pageable);
    Page<Order> findAllByCreatedDateOrderByCreatedDateAsc(String search,Pageable pageble);
    Page<Order>findAlLOrOrderByCreatedDate(String search, Pageable pageable);
}
