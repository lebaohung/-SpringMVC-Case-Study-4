package com.codegym.cms.controller;//package com.codegym.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/")
    public String homepage() {
        return "/index";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/login/loginForm";
    }

    @PostMapping("/loginForm")
    public ModelAndView redirectLogin() {
        ModelAndView modelAndView = new ModelAndView("/login/loginForm");
        modelAndView.addObject("message", "Welcome!Thanks for creat a new account");
        return modelAndView;
    }

    //    @GetMapping("/sigup")
//    public String signUp(){
//        return "/login/signUp";
//    }

    @GetMapping("/sigup")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView("/login/signUp");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }


    @GetMapping("/accessDenied")
    public ModelAndView accessDenied() {
        return new ModelAndView("/404");
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login/loginForm";
    }

    @GetMapping("/province")
    public ModelAndView showProvinces() {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("provinces", provinces());
        return modelAndView;
    }
}


