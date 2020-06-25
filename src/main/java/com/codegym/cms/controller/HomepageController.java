package com.codegym.cms.controller;//package com.codegym.controller;

import com.codegym.cms.model.AppRole;
import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.AppUserService;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.Role;

@Controller
public class HomepageController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CustomerService customerService;


    @Autowired
    private AppUserService appUserService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping(value = {"/", "/home"})
    public String Homepage(Model model){
        model.addAttribute("user", appUserService.getCurrentUser());
        return "/index";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/login/loginForm";
    }

    @PostMapping("/sigup")
    public ModelAndView redirectLogin(@ModelAttribute("customer") Customer customer) {


        try {
            customer.setUserStatus(true);

            customer.setRole(new AppRole());
            customer.getRole().setId((long) 2);

            customerService.save(customer);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("/login/signUp");
            modelAndView.addObject("emailExist", true);
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("/login/loginForm");
        modelAndView.addObject("message", true);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }


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


