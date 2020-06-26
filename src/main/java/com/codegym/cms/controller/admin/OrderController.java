package com.codegym.cms.controller.admin;

import com.codegym.cms.model.admin.Order;
import com.codegym.cms.model.admin.Province;
import com.codegym.cms.model.admin.Status;
import com.codegym.cms.model.admin.User;
import com.codegym.cms.service.admin.IOrderService;
import com.codegym.cms.service.admin.IProvinceService;
import com.codegym.cms.service.admin.IStatusService;
import com.codegym.cms.service.admin.IUserService;
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
    private IOrderService iOrderService;
    @Autowired
    private IProvinceService iProvinceService;
    @Autowired
    private IStatusService iStatusService;
    @Autowired
    private IUserService iUserService;

    @ModelAttribute("provinces")
    public List<Province> provinces() {
        return iProvinceService.findAll();
    }

    @ModelAttribute("statusess")
    public List<Status> statusess() {
        return iStatusService.findAll();
    }

    @ModelAttribute
    public List<User> users() {
        return iUserService.findAll();
    }


    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("searchs") Optional<String> searchs) {
        Page<Order> orders;
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/list");
        if (searchs.isPresent()) {
            orders = iOrderService.findAllByReceiverNameContaining(
                    searchs.get(), pageable);
            modelAndView.addObject("searchs", searchs);
        } else {
            orders = iOrderService.findAll(pageable);
        }

        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/create");
        modelAndView.addObject("orders", new Order());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("orders") Order orders) {
        iOrderService.save(orders);
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/create");
        modelAndView.addObject("orders", new Order());
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Order order = iOrderService.findById(id);
        if (order != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudOrder/edit");
            modelAndView.addObject("orders", order);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("orders") Order orders) {
        iOrderService.save(orders);
        ModelAndView modelAndView = new ModelAndView("admin/crudOrder/edit");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Order order = iOrderService.findById(id);
        if (order != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudOrder/delete");
            modelAndView.addObject("orders", order);
            return modelAndView;

        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("orders") Order order) {
        iOrderService.remove(order.getOrderId());
        return new ModelAndView("redirect:admin/crudOrder/list");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Long id) {
        Order order = iOrderService.findById(id);
        if (order != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudOrder/view");
            modelAndView.addObject("orders", order);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

}

