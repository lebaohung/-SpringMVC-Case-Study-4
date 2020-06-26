package com.codegym.cms.service.admin.impl;

import com.codegym.cms.model.admin.Order;
import com.codegym.cms.repository.admin.IOrderRepository;
import com.codegym.cms.service.admin.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class OrderServiceImpl implements IOrderService {
    @Override
    public Page<Order> findAllByReceiverNameContaining(String search, Pageable pageable) {
        return iOrderRepository.findAllByReceiverNameContaining(search,pageable);
    }

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }

    @Override
    public Order findById(Long id) {
        return iOrderRepository.findOne(id);
    }

    @Override
    public void save(Order model) {
        iOrderRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        iOrderRepository.delete(id);
    }
}
