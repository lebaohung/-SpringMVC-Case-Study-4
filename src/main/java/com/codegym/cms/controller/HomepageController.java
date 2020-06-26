package com.codegym.cms.controller;//package com.codegym.controller;

//import com.codegym.cms.model.AppRole;

import com.codegym.cms.model.AppRole;
import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
//import com.codegym.cms.service.CustomerService;
//import com.codegym.cms.service.ProvinceService;
import com.codegym.cms.service.appuser.AppUserService;
import com.codegym.cms.service.customer.CustomerService;
import com.codegym.cms.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
    @Autowired
    private AppUserService userService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CustomerService customerService;


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

    @PostMapping("/sigup")
    public ModelAndView redirectLogin(@ModelAttribute("customer") Customer customer) {


        try {
            customer.setCustomerStatus(true);
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
        modelAndView.addObject("customer", customer);
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

    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess() {
        Long currentCustomerId = userService.getCurrentUser().getCustomerId();
        Customer currentCustomer = customerService.findbyId(currentCustomerId);
        ModelAndView modelAndView;
        if (currentCustomer.getRole().getId() == 1) {
//            modelAndView = new ModelAndView("/admin/crudUser/list");
            modelAndView = new ModelAndView("/test");
        } else {
            modelAndView = new ModelAndView("/index");
        }
        modelAndView.addObject("curCustomer", currentCustomer);
        modelAndView.addObject("greeting",currentCustomer.getName());
        return modelAndView;
    }


}


