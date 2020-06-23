package service.impl;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.IAdminRepository;
import service.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminRepository iAdminRepository;

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return iAdminRepository.findAll(pageable);
    }

    @Override
    public Admin findById(Long id) {
        return iAdminRepository.findOne(id);
    }

    @Override
    public void save(Admin model) {
        iAdminRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        iAdminRepository.delete(id);
    }

    @Override
    public Page<Admin> findAdminByNameContaining(String name, Pageable pageable) {
        return iAdminRepository.findAdminByNameContaining(name, pageable);
    }
}
