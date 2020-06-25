package com.codegym.cms;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity {
    @Autowired
    private AppUserRepository userRepository;

    public boolean checkUserId(Authentication authentication, String id) {
        String email = authentication.getName();
        Customer result = userRepository.findByEmail(email);
        return result != null && result.getUserId().toString().equals(id);
    }
}
