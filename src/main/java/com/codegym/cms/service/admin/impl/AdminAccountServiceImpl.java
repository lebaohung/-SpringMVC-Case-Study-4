package com.codegym.cms.service.admin.impl;

import com.codegym.cms.model.admin.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.codegym.cms.repository.admin.IAdminAccountRepository;
import com.codegym.cms.service.admin.IAdminAccountService;

public class AdminAccountServiceImpl implements IAdminAccountService {
    @Autowired
    private IAdminAccountRepository iAdminAccountRepository;

    @Override
    public Page<AdminAccount> findAll(Pageable pageable) {
        return iAdminAccountRepository.findAll(pageable);
    }

    @Override
    public AdminAccount findById(Long id) {
        return iAdminAccountRepository.findOne(id);
    }

    @Override
    public void save(AdminAccount model) {
        iAdminAccountRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        iAdminAccountRepository.delete(id);
    }
}
