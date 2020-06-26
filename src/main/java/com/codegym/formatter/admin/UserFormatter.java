package com.codegym.formatter.admin;

import com.codegym.model.admin.User;
import com.codegym.service.admin.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class UserFormatter implements Formatter<User> {
    @Autowired
    private IUserService iUserService;

    @Autowired
    public UserFormatter(IUserService iUserService) {
        this.iUserService=iUserService;
    }

    @Override
    public User parse(String text, Locale locale) throws ParseException {
        return iUserService.findById(Long.parseLong(text));
    }

    @Override
    public String print(User object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
