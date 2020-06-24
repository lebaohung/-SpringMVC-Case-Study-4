package service.admin;

import model.admin.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IService<User> {
    Page<User> findAllByNameContaining(String search, Pageable pageable);
}
