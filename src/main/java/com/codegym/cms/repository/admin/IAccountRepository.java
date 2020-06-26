package com.codegym.cms.repository.admin;

import com.codegym.cms.model.admin.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account,Long> {
    Page<Account> findAllByEmailContaining(String search, Pageable pageable);
    List<Account> findAll();
}
