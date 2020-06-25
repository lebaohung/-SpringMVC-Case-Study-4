package com.codegym.controller.admin;


import com.codegym.model.admin.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.service.admin.IProvinceService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/admin/province")
public class ProvinceController {

    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("search") Optional<String> search,
                             HttpServletRequest request) {
        String searchValue = request.getParameter("search");
        Page<Province> provinces;
        ModelAndView modelAndView = new ModelAndView("admin/crudProvince/list");
        if (search.isPresent()) {
            provinces = iProvinceService.findAllByNameContaining(search.get(), pageable);
        } else {
            provinces = iProvinceService.findAll(pageable);

        }
        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("admin/crudProvince/create");
        modelAndView.addObject("provinces", new Province());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("provinces") Province provinces) {
        iProvinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("admin/crudProvince/create");
        modelAndView.addObject("provinces", new Province());

        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Province provinces = iProvinceService.findById(id);
        if (provinces != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudProvince/edit");
            modelAndView.addObject("provinces", provinces);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("provinces") Province provinces) {
        iProvinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("admin/crudProvince/edit");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Province provinces = iProvinceService.findById(id);
        if (provinces != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudProvince/delete");
            modelAndView.addObject("provinces", provinces);
            return modelAndView;

        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("provinces") Province provinces) {
        iProvinceService.remove(provinces.getId());
        return new ModelAndView("redirect:admin/crudProvince/list");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Long id) {
        Province provinces = iProvinceService.findById(id);
        if (provinces != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudProvince/view");
            modelAndView.addObject("provinces", provinces);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }
}
