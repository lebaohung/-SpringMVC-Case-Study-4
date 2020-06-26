package com.codegym.cms.formatter.admin;

import com.codegym.cms.model.admin.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import com.codegym.cms.service.admin.IfProvinceService;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFormatter implements Formatter<Province> {
    @Autowired
    private IfProvinceService ifProvinceService;

    @Autowired
    public ProvinceFormatter(IfProvinceService ifProvinceService) {
        this.ifProvinceService = ifProvinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return ifProvinceService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}
