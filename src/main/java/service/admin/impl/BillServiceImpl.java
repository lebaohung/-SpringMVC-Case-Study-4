package service.admin.impl;

import model.admin.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.admin.IBillRepository;
import service.admin.IBillService;

public class BillServiceImpl implements IBillService {
    @Override
    public Page<Bill> findAllByIdContaining(String search, Pageable pageable) {
        return iBillRepository.findAllByIdContaining(search,pageable);
    }

    @Autowired
    private IBillRepository iBillRepository;

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return iBillRepository.findAll(pageable);
    }

    @Override
    public Bill findById(Long id) {
        return iBillRepository.findOne(id);
    }

    @Override
    public void save(Bill model) {
        iBillRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        iBillRepository.delete(id);
    }
}
