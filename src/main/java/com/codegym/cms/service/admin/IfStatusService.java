package com.codegym.cms.service.admin;

import com.codegym.cms.model.admin.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IfStatusService extends IfService<Status> {
    Page<Status> findAllByNameContaining(String search, Pageable pageable);

    List<Status> findAll();
}
