package com.codegym.cms.controller.admin;


import com.codegym.cms.model.admin.AvatarUpload;
import com.codegym.cms.model.admin.Province;
import com.codegym.cms.model.admin.Status;
import com.codegym.cms.model.admin.User;
import com.codegym.cms.service.admin.IOrderService;
import com.codegym.cms.service.admin.IProvinceService;
import com.codegym.cms.service.admin.IStatusService;
import com.codegym.cms.service.admin.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {
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

    @Autowired
    Environment env;


    @ModelAttribute("provinces")
    public Page<Province> provinces(Pageable pageable) {
        return iProvinceService.findAll(pageable);
    }

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("searchs") Optional<String> searchs) {
        Page<User> users;
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/list");
        if (searchs.isPresent()) {
            users = iUserService.findAllByNameContaining(searchs.get(), pageable);
            modelAndView.addObject("searchs", searchs);
        } else {
            users = iUserService.findAll(pageable);

        }
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView homes(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("searchs") Optional<String> searchs) {
        Page<User> users;
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/list");
        if (searchs.isPresent()) {
            users = iUserService.findAllByNameContaining(searchs.get(), pageable);
            modelAndView.addObject("searchs", searchs);
        } else {
            users = iUserService.findAll(pageable);

        }
        modelAndView.addObject("users", users);
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        User users = iUserService.findById(id);
        if (users != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudUser/edit");
            modelAndView.addObject("users", users);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("users") AvatarUpload avatarUpload, User userss) {
        User users = new User(userss.getName(), userss.getDetailAddress(), null);

        MultipartFile multipartFile = avatarUpload.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload");
        try {
            FileCopyUtils.copy(avatarUpload.getAvatar().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.setAvatar(fileName);

        iUserService.save(users);
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/edit");
        modelAndView.addObject("users", users);
        return modelAndView;
    }


    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Long id) {
        User users = iUserService.findById(id);
        if (users != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudUser/view");
            modelAndView.addObject("users", users);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

}
