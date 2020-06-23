package repository;

import model.AdminAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAdminAccountRepository extends PagingAndSortingRepository<AdminAccount, Long> {
}
