package controller.admin;

import model.admin.Bill;
import model.admin.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.admin.IBillService;
import service.admin.IProvinceService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
@RequestMapping("/admin/bill")
public class BIllController {

    @Autowired
    private IBillService iBillService;
    @Autowired
    private IProvinceService iProvinceService;

    @ModelAttribute("provinces")
    public Page<Province> provinces(Pageable pageable) {
        return iProvinceService.findAll(pageable);
    }

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 2, direction = Sort.Direction.ASC)
                                     Pageable pageable,
                             @RequestParam("search") Optional<String> search,
                             HttpServletRequest request) {
        String searchValue = request.getParameter("search");
        Page<Bill> bills;
        ModelAndView modelAndView = new ModelAndView("admin/crudBill/list");
        if (search.isPresent()) {
            bills = iBillService.findAllByIdContaining(search.get(), pageable);
        } else {
            bills = iBillService.findAll(pageable);

        }
        modelAndView.addObject("bills", bills);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("admin/crudBill/create");
        modelAndView.addObject("bills", new Bill());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("bills") Bill bills) {
        iBillService.save(bills);
        ModelAndView modelAndView = new ModelAndView("admin/crudBill/create");
        modelAndView.addObject("bills", new Bill());
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Bill bill = iBillService.findById(id);
        if (bill != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudBill/edit");
            modelAndView.addObject("bills", bill);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("bills") Bill bill) {
        iBillService.save(bill);
        ModelAndView modelAndView = new ModelAndView("admin/crudBill/edit");
        modelAndView.addObject("bills", bill);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Bill bill = iBillService.findById(id);
        if (bill != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudBill/delete");
            modelAndView.addObject("bills", bill);
            return modelAndView;

        } else {
            return new ModelAndView("admin/404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("bills") Bill bill) {
        iBillService.remove(bill.getId());
        return new ModelAndView("redirect:admin/crudBill/list");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Long id) {
        Bill bill = iBillService.findById(id);
        if (bill != null) {
            ModelAndView modelAndView = new ModelAndView("admin/crudBill/view");
            modelAndView.addObject("bills", bill);
            return modelAndView;
        } else {
            return new ModelAndView("admin/404");
        }
    }
}

