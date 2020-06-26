package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.OrderStatus;
import com.codegym.cms.model.Order;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.OrderStatus.IOrderStatusService;
import com.codegym.cms.service.order.IOrderService;
import com.codegym.cms.service.province.IProvinceService;
import com.codegym.cms.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private IOrderStatusService orderStatusService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @ModelAttribute("orderStatuses")
    public Iterable<OrderStatus> orderStatuses() {
        return orderStatusService.findAll();
    }


    @GetMapping("/info/{id}")
    public ModelAndView showCustomerInfo(@PathVariable Long id) {
        Customer customer = customerService.findbyId(id);
        Province province = provinceService.findById(customer.getProvinceId());

        if (customer.getName() != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/detail");
            modelAndView.addObject(customer);
            modelAndView.addObject(province);
            return modelAndView;
        } else {
            return new ModelAndView("/customer/error");
        }
    }

    @PostMapping("/info/{id}")
    public ModelAndView editCostomerInfo(@PathVariable Long id,@ModelAttribute Customer customer) {
        Customer chosenCustomer = customerService.findbyId(id);
        customer.setCustomerId(chosenCustomer.getCustomerId());
        customer.setPassword(chosenCustomer.getPassword());
        customer.setCustomerStatus(chosenCustomer.isCustomerStatus());
        try {
            customerService.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/customer/detail");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Edit info successfully");
        return modelAndView;
    }

    @GetMapping("/orders/{id}")
    public  ModelAndView listOrders(@PathVariable Long id,@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/order/list");
        Page<Order> orders = orderService.findAllByCustomerId(id, pageable);
        Long customerId = id;
        modelAndView.addObject("customerId", customerId);
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/order-detail/{id}")
    public ModelAndView showOrder(@PathVariable Long id) {
        Order order = orderService.findbyId(id);

        if (order != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/order/detail");
            modelAndView.addObject("order", order);
            return modelAndView;
        }
        return new ModelAndView("/customer/error");
    }

    @PostMapping("/order-detail/{id}")
    public ModelAndView editOrder(@PathVariable Long id, @ModelAttribute Order order) {
        Order chosenOrder = orderService.findbyId(id);
        order.setCustomerId(chosenOrder.getCustomerId());
        order.setCreatedDate(chosenOrder.getCreatedDate());
        order.setStatus(chosenOrder.getStatus());
        order.setOrderId(id);
        try {
            orderService.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/customer/order/detail");
        modelAndView.addObject("order", order);
        modelAndView.addObject("message", "Edit info successfully");
        return modelAndView;
    }

    @GetMapping("/create-order/{id}")
    public ModelAndView createOrder(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/order/create");
        Order order = new Order();
        order.setCustomerId(id);
        modelAndView.addObject(order);
        return modelAndView;
    }

    @PostMapping("/create-order/{id}")
    public ModelAndView saveOrder(@PathVariable Long id, @ModelAttribute Order order) {
        ModelAndView modelAndView = new ModelAndView("/customer/order/create");
        order.setCustomerId(id);
        order.setStatus(1);

        long millis = System.currentTimeMillis();
        Date createdDate = new Date(millis);
        order.setCreatedDate(createdDate);
        String temp = order.getReceiverAddress().trim();
        order.setReceiverAddress(temp);
        try {
            orderService.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("message", "Create new order successfully");
        return modelAndView;
    }
}