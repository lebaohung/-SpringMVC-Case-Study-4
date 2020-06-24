package repository.admin;

import model.admin.AdminAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminAccountRepository extends PagingAndSortingRepository<AdminAccount, Long> {
}
