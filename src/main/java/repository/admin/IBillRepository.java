package repository.admin;

import model.admin.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends PagingAndSortingRepository<Bill,Long> {
    Page<Bill> findAllByIdContaining(String search, Pageable pageable);
}
