package service.admin;

import model.admin.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService extends IService<Bill> {
    Page<Bill> findAllByIdContaining(String search, Pageable pageable);
}
