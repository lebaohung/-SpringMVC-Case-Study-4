package com.codegym.cms.controller;//package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homepage(){
        return "/index";
    }

    @GetMapping("/loginForm")
        public String loginForm(){
            return "/login/loginForm";
    }

    @GetMapping("/sigup")
    public String signUp(){
        return "/login/signUp";
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
}


