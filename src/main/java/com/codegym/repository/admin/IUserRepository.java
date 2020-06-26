package com.codegym.repository.admin;

import com.codegym.model.admin.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByNameContaining(String search, Pageable pageable);

    List<User> findAll();
}
