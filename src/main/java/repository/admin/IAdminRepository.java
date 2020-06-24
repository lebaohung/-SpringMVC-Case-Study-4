package repository.admin;

import model.admin.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAdminRepository extends PagingAndSortingRepository<Admin,Long> {
  Page<Admin> findAdminByNameContaining(String name, Pageable pageable);
}
