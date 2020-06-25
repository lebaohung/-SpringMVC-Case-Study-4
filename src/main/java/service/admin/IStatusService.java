package service.admin;

import model.admin.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStatusService extends IService<Status>{
    Page<Status> findAllByNameContaining(String search, Pageable pageable);
}
