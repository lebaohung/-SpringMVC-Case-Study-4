package com.codegym.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempUserController {

    @GetMapping("/user")
    public String showUserHomePage() {
        return "user/detail";
    }

    @GetMapping("/orders")
    public String listOrders() {
        return "user/order/list";
    }

    @GetMapping("/create-order")
    public String createOrder() {
        return "user/order/create";
    }

}
