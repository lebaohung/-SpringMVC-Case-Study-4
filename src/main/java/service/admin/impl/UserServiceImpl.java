package service.admin.impl;

import model.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.admin.IUserRepository;
import service.admin.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public Page<User> findAllByNameContaining(String search,Pageable pageable) {
        return iUserRepository.findAllByNameContaining(search,pageable);
    }

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findOne(id);
    }

    @Override
    public void save(User model) {
iUserRepository.save(model);
    }

    @Override
    public void remove(Long id) {
iUserRepository.delete(id);
    }
}
