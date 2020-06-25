package repository.admin;

import model.admin.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends PagingAndSortingRepository<Status,Long> {
    Page<Status> findAllByNameContaining(String search, Pageable pageable);
}
