package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class abc {
    @GetMapping("/")
    ModelAndView index(){
        return new ModelAndView("admin/crudAdmin/list");
    }
    @GetMapping("/a")
    ModelAndView a(){
        return new ModelAndView("admin/404");
    }
}
