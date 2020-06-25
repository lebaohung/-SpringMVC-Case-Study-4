package com.codegym.cms.controller;

import com.codegym.cms.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

//    @Autowired
//    private AppUserService appUserService;
//    @GetMapping(value = {"/", "/home"})
//    public String Homepage(Model model){
//        model.addAttribute("user", appUserService.getCurrentUser());
//        return "/index";
//    }

}
