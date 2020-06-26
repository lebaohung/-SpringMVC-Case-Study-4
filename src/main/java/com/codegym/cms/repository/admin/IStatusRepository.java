package com.codegym.cms.repository.admin;

import com.codegym.cms.model.admin.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStatusRepository extends PagingAndSortingRepository<Status,Long> {
    Page<Status> findAllByNameContaining(String search, Pageable pageable);
    List<Status> findAll();
}
