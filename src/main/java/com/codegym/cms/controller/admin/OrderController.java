package com.codegym.cms.controller.admin;

import com.codegym.cms.model.admin.Order;
import com.codegym.cms.model.admin.Province;
import com.codegym.cms.model.admin.Status;
import com.codegym.cms.model.admin.User;
import com.codegym.cms.service.admin.IfOrderService;
import com.codegym.cms.service.admin.IfProvinceService;
import com.codegym.cms.service.admin.IfStatusService;
import com.codegym.cms.service.admin.IfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private IfOrderService ifOrderService;
    @Autowired
    private IfProvinceService ifProvinceService;
    @Autowired
    private IfStatusService ifStatusService;
    @Autowired
    private IfUserService ifUserService;

    @ModelAttribute("provinces")
    public List<Province> provinces() {
        return ifProvinceService.findAll();
    }

    @ModelAttribute("statusess")
    public List<Status> statusess() {
        return ifStatusService.findAll();
    }

    @ModelAttribute
    public List<User> users() {
        return ifUserService.findAll();
    }


    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("searchs") Optional<String> searchs) {
        Page<Order> orders;
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/list");
        if (searchs.isPresent()) {
            orders = ifOrderService.findAllByReceiverNameContaining(
                    searchs.get(), pageable);
            modelAndView.addObject("searchs", searchs);
        } else {
            orders = ifOrderService.findAll(pageable);
        }

        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
    @GetMapping("")
    public ModelAndView homes(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("searchs") Optional<String> searchs) {
        Page<Order> orders;
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/list");
        if (searchs.isPresent()) {
            orders = ifOrderService.findAllByReceiverNameContaining(
                    searchs.get(), pageable);
            modelAndView.addObject("searchs", searchs);
        } else {
            orders = ifOrderService.findAll(pageable);
        }

        modelAndView.addObject("orders", orders);
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Order orders = ifOrderService.findById(id);
        if (orders != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudOrder/edit");
            modelAndView.addObject("orders", orders);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("orders") Order orders) {
        ifOrderService.save(orders);
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/edit");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }


    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Long id) {
        Order orders = ifOrderService.findById(id);
        if (orders != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudOrder/view");
            modelAndView.addObject("orders", orders);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }


//    @GetMapping("/edit/{id}")
//    public ModelAndView editForms(@PathVariable Long id) {
//        Order orders = ifOrderService.findById(id);
//        if (orders != null) {
//            ModelAndView modelAndView = new ModelAndView("admin/crudOrder/test");
//            modelAndView.addObject("orders", orders);
//            return modelAndView;
//        } else {
//            return new ModelAndView("admin/404");
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView updates(@ModelAttribute("orders") Order orders) {
//        ifOrderService.save(orders);
//        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/test");
//        modelAndView.addObject("orders", orders);
//        return modelAndView;
//    }






}

