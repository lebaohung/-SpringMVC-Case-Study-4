//package com.codegym.cms.controller;
//
//import com.codegym.cms.model.Order;
//import com.codegym.cms.service.AppUserService;
//import com.codegym.cms.service.CustomerService;
//import com.codegym.cms.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//public class CustomerController {
//
//    @Autowired
//    private OrderService orderService;
//    @Autowired
//    private AppUserService customerService;
//
//
//
//    @GetMapping("/customers")
//    public ModelAndView listTask(){
//        ModelAndView modelAndView = new ModelAndView("/task/list");
//        List<Order> orders = (List<Order>) orderService.findAllByUser(customerService.getCurrentUser());
//        modelAndView.addObject("orders", orders);
//        return modelAndView;
//    }
//}
