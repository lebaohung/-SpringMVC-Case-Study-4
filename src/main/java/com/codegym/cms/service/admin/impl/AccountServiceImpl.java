package com.codegym.cms.service.admin.impl;

import com.codegym.cms.model.admin.Account;
import com.codegym.cms.repository.admin.IAccountRepository;
import com.codegym.cms.service.admin.IfAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AccountServiceImpl implements IfAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return iAccountRepository.findAll(pageable);
    }

    @Override
    public Account findById(Long id) {
        return iAccountRepository.findOne(id);
    }

    @Override
    public void save(Account model) {
    iAccountRepository.save(model);
    }

    @Override
    public void remove(Long id) {
    iAccountRepository.delete(id);
    }

    @Override
    public Page<Account> findAllByEmailContaining(String search, Pageable pageable) {
        return iAccountRepository.findAllByEmailContaining(search,pageable);
    }

    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }

}
