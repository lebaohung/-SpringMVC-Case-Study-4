package service.admin.impl;

import model.admin.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.admin.IProvinceRepository;
import service.admin.IProvinceService;

public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return iProvinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        return iProvinceRepository.findOne(id);
    }

    @Override
    public void save(Province model) {
        iProvinceRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.delete(id);
    }

    @Override
    public Page<Province> findAllByNameContaining(String search, Pageable pageable) {
        return iProvinceRepository.findAllByNameContaining(search,pageable);
    }
}
