package com.codegym.cms.repository;

import com.codegym.cms.model.OrderStatus;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer> {
}
