package com.codegym.cms.service.admin;

import com.codegym.cms.model.admin.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IfOrderService extends IfService<Order> {

    Page<Order> findAllByReceiverNameContaining(String search, Pageable pageable);

}
