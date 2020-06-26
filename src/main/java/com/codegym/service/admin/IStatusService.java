package com.codegym.service.admin;

import com.codegym.model.admin.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStatusService extends IService<Status> {
    Page<Status> findAllByNameContaining(String search, Pageable pageable);

    List<Status> findAll();
}
