package service.admin;

import model.admin.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProvinceService extends IService<Province> {
    Page<Province> findAllByNameContaining(String search, Pageable pageable);
}
