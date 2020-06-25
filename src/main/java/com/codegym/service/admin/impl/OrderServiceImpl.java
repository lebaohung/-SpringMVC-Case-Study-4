package com.codegym.service.admin.impl;

import com.codegym.model.admin.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.codegym.repository.admin.IOrderRepository;
import com.codegym.service.admin.IOrderService;

import java.util.Date;

public class OrderServiceImpl implements IOrderService {
    @Override
    public Page<Order> findAllByOrderIdContaining(String search, Pageable pageable) {
        return iOrderRepository.findAllByOrderIdContaining(search,pageable);
    }

    @Override
    public Page<Order> findAlLOrOrderByCreatedDate(String search, Pageable pageable) {
        return iOrderRepository.findAlLOrOrderByCreatedDate(search,pageable);
    }

    @Override
    public Page<Order> findAllByCreatedDateOrderByCreatedDateAsc(String search, Pageable pageble) {
        return iOrderRepository.findAllByCreatedDateOrderByCreatedDateAsc(search,pageble);
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
