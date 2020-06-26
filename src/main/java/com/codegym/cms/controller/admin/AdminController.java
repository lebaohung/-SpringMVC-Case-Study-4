package com.codegym.cms.controller.admin;

import com.codegym.cms.model.admin.Admin;
import com.codegym.cms.model.admin.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.cms.service.admin.IAdminAccountService;
import com.codegym.cms.service.admin.IAdminService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService iAdminService;
    @Autowired
    private IAdminAccountService iAdminAccountService;

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("search") Optional<String> search,
                             HttpServletRequest request) {
        String searchValue = request.getParameter("search");
        Page<Admin> admins;
        ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/list");
        if (search.isPresent()) {
            admins = iAdminService.findAdminByNameContaining(search.get(), pageable);
        } else {
            admins = iAdminService.findAll(pageable);
        
        }
        modelAndView.addObject("admins", admins);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/create");
        modelAndView.addObject("admins", new Admin());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("admins") Admin admins) {
        iAdminService.save(admins);
        ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/create");
        modelAndView.addObject("admins", new Admin());
        modelAndView.addObject("adminAccounts",new AdminAccount());

        return modelAndView;
    }

    @GetMapping("/createAccount")
    public ModelAndView createFormAccount() {
        ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/createAccount");
        modelAndView.addObject("adminAccounts", new AdminAccount());
        return modelAndView;
    }

    @PostMapping("/createAccount")
    public ModelAndView createAccount(@ModelAttribute("adminAccounts") AdminAccount adminAccount
    ) {
        iAdminAccountService.save(adminAccount);
        ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/createAccount");
        modelAndView.addObject("adminAccounts", new AdminAccount());
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Admin admin = iAdminService.findById(id);
        if (admin != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/edit");
            modelAndView.addObject("admins", admin);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("admins") Admin admin) {
        iAdminService.save(admin);
        ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/edit");
        modelAndView.addObject("admins", admin);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Admin admin = iAdminService.findById(id);
        if (admin != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/delete");
            modelAndView.addObject("admins", admin);
            return modelAndView;

        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("admins") Admin admin) {
        iAdminService.remove(admin.getId());
        return new ModelAndView("redirect:admin/crudAdmin/list");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Long id) {
        Admin admin = iAdminService.findById(id);
        if (admin != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudAdmin/view");
            modelAndView.addObject("admins", admin);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

}
