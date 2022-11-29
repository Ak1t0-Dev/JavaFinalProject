package com.onlinepetstore.docastoreproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlinepetstore.docastoreproject.domain.model.CategoryProduct;
import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.service.CategoryProductService;
import com.onlinepetstore.docastoreproject.service.EmployeeService;

@Controller
@RequestMapping("/categoryProduct")
public class CategoryProductController {

    @Autowired
    CategoryProductService categoryProductService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String showData(Model model, @ModelAttribute("categoryProductService") CategoryProduct categoryProduct) {
        List<CategoryProduct> categoryProductList = categoryProductService.selectAll();
        model.addAttribute("categoryProductList", categoryProductList);
        return "categoryProduct";
    }

    @PostMapping("/insert")
    public String insert(Model model,
            @Validated @ModelAttribute("categoryProductService") CategoryProduct categoryProduct,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.select(1);
        if (result.hasErrors()) {
            return showData(model, categoryProduct);
        }
        categoryProductService.insert(categoryProduct, employee);
        return "redirect:/categoryProduct";
    }

    // update a record
    @PostMapping("/update")
    public String update(Model model, @Validated @ModelAttribute("newcategory") CategoryProduct categoryProduct,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.select(1);
        if (result.hasErrors()) {
            return showData(model, categoryProduct);
        }
        categoryProductService.update(categoryProduct, employee);
        return "redirect:/categoryProduct";
    }

    // delete a record
    @PostMapping("/delete")
    public String delete(int categoryProductId) {
        categoryProductService.delete(categoryProductId);
        return "redirect:/categoryProduct";
    }
}
