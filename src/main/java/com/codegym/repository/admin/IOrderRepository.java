package com.codegym.repository.admin;

import com.codegym.model.admin.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends PagingAndSortingRepository<Order,Long> {
    Page<Order> findAllByOrderIdContaining(String search, Pageable pageable);
    Page<Order> findAllByCreatedDateOrderByCreatedDateAsc(String search,Pageable pageble);
    Page<Order>findAlLOrOrderByCreatedDate(String search, Pageable pageable);
}
