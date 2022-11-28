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
import com.onlinepetstore.docastoreproject.service.CategoryProductService;
import com.onlinepetstore.docastoreproject.service.EmployeeService;

@Controller
@RequestMapping("/categoryProduct")
public class CategoryProductController {

    @Autowired
    CategoryProductService categoryProductService;
    EmployeeService employeeService;

    @GetMapping
    public String showData(Model model, @ModelAttribute("categoryProductService") CategoryProduct categoryProduct) {
        List<CategoryProduct> categoryProductList = categoryProductService.selectAll();
        model.addAttribute("categoryProductList", categoryProductList);
        model.addAttribute("categoryProduct", new CategoryProduct());
        return "categoryProduct";
    }

    @PostMapping("/insert")
    public String insert(Model model,
            @Validated @ModelAttribute("categoryProductService") CategoryProduct categoryProduct,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        categoryProductService.insert(categoryProduct);
        return "redirect:/categoryProduct";
    }

}
