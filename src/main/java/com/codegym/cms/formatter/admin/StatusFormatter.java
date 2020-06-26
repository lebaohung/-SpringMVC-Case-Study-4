package com.codegym.cms.formatter.admin;

import com.codegym.cms.model.admin.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import com.codegym.cms.service.admin.IfStatusService;

import java.text.ParseException;
import java.util.Locale;

public class StatusFormatter implements Formatter<Status> {
    @Autowired
    private IfStatusService ifStatusService;

    @Autowired
    public StatusFormatter(IfStatusService ifStatusService) {
        this.ifStatusService = ifStatusService;
    }

    @Override
    public Status parse(String text, Locale locale) throws ParseException {
        return ifStatusService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Status object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}
