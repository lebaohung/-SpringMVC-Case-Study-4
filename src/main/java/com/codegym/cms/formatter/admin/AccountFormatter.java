package com.codegym.cms.formatter.admin;

import com.codegym.cms.model.admin.Account;
import com.codegym.cms.service.admin.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AccountFormatter implements Formatter<Account> {
    @Autowired
    private IAccountService iAccountService;

    @Autowired
    public AccountFormatter(IAccountService iAccountService) {
        this.iAccountService=iAccountService;
    }

    @Override
    public Account parse(String text, Locale locale) throws ParseException {
        return iAccountService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Account object, Locale locale) {
        return "[" + object.getId() + ", " +object.getEmail() + "]";
    }
}
