package com.codegym.cms.formatter.admin;

import com.codegym.cms.model.admin.User;
import com.codegym.cms.service.admin.IfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class UserFormatter implements Formatter<User> {
    @Autowired
    private IfUserService ifUserService;

    @Autowired
    public UserFormatter(IfUserService ifUserService) {
        this.ifUserService = ifUserService;
    }

    @Override
    public User parse(String text, Locale locale) throws ParseException {
        return ifUserService.findById(Long.parseLong(text));
    }

    @Override
    public String print(User object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
