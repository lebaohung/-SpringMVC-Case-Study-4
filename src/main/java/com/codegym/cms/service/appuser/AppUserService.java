package com.codegym.cms.service.appuser;
import com.codegym.cms.model.Customer;

public interface AppUserService {
    Customer getUserByEmail(String username);
    Customer getCurrentUser();
}
