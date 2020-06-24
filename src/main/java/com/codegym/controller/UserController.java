package com.codegym.controller;

import com.codegym.model.Order;
import com.codegym.model.Province;
import com.codegym.model.User;
import com.codegym.service.order.IOrderService;
import com.codegym.service.order.OrderService;
import com.codegym.service.province.IProvinceService;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/info/{id}")
    public ModelAndView showUserInfo(@PathVariable Long id) {
        User user = userService.findbyId(id);
        Province province = provinceService.findById(user.getProvinceId());
        System.out.println(user.getName());

        if (user.getName() != null) {
            ModelAndView modelAndView = new ModelAndView("user/detail");
            modelAndView.addObject(user);
            modelAndView.addObject(province);
            return modelAndView;
        } else {
            return new ModelAndView("user/error");
        }
    }

    @PostMapping("/info/{id}")
    public ModelAndView editCostomerInfo(@PathVariable Long id,@ModelAttribute User user) {
        User chosenUser = userService.findbyId(id);
        user.setUserId(chosenUser.getUserId());
        user.setPassword(chosenUser.getPassword());
        user.setUserStatus(chosenUser.isUserStatus());
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/user/detail");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "Edit info successfully");
        return modelAndView;
    }

    @GetMapping("/orders/{id}")
    public String listOrders(@PathVariable String id) {
        return "user/order/list";
    }

    @GetMapping("/create-order/{id}")
    public String createOrder(@PathVariable String id) {
        return "user/order/create";
    }

}
