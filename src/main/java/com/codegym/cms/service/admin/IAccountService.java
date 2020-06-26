package com.codegym.cms.service.admin;

import com.codegym.cms.model.admin.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService extends IService<Account>{
    Page<Account> findAllByEmailContaining(String search, Pageable pageable);
    List<Account> findAll();
}
