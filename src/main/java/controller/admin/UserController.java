package controller.admin;


import model.admin.Province;
import model.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.admin.IProvinceService;
import service.admin.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IProvinceService iProvinceService;

    @ModelAttribute("provinces")
    public Page<Province>provinces(Pageable pageable){return iProvinceService.findAll(pageable);}

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("search") Optional<String> search,
                             HttpServletRequest request) {
        String searchValue = request.getParameter("search");
        Page<User> users;
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/list");
        if (search.isPresent()) {
            users = iUserService.findAllByNameContaining(search.get(), pageable);
        } else {
            users = iUserService.findAll(pageable);

        }
        modelAndView.addObject("users", users);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/create");
        modelAndView.addObject("users", new User());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("users") User users) {
        iUserService.save(users);
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/create");
        modelAndView.addObject("users", new User());

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
    public ModelAndView update(@ModelAttribute("users") User users) {
        iUserService.save(users);
        ModelAndView modelAndView = new ModelAndView("admin/crudUser/edit");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        User users = iUserService.findById(id);
        if (users != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudUser/delete");
            modelAndView.addObject("users", users);
            return modelAndView;

        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("users") User users) {
        iUserService.remove(users.getId());
        return new ModelAndView("redirect:admin/crudUser/list");
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