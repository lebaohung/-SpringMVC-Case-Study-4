package repository;

import model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminRepository extends PagingAndSortingRepository<Admin,Long> {
  Page<Admin> findAdminByNameContaining(String name, Pageable pageable);
}
