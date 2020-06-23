package service;

import model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAdminService extends IService<Admin> {
    Page<Admin> findAdminByNameContaining(String name, Pageable pageable);
}
