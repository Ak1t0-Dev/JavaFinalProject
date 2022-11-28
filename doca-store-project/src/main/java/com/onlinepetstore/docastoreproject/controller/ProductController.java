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

import com.onlinepetstore.docastoreproject.service.CategoryPetService;
import com.onlinepetstore.docastoreproject.service.CategoryProductService;
import com.onlinepetstore.docastoreproject.service.EmployeeService;
import com.onlinepetstore.docastoreproject.service.ProductService;
import com.onlinepetstore.docastoreproject.domain.model.Product;
import com.onlinepetstore.docastoreproject.domain.model.CategoryPet;
import com.onlinepetstore.docastoreproject.domain.model.CategoryProduct;
import com.onlinepetstore.docastoreproject.domain.model.Employee;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryPetService categoryPetService;
    @Autowired
    CategoryProductService categoryProductService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String showData(Model model) {
        List<Product> productList = productService.selectAll();
        List<CategoryPet> categoryPetList = categoryPetService.selectAll();
        List<CategoryProduct> categoryProductList = categoryProductService.selectAll();
        model.addAttribute("categoryProductList", categoryProductList);
        model.addAttribute("productList", productList);
        model.addAttribute("categoryPetList", categoryPetList);
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/insert")
    public String insert(Model model,
            @Validated @ModelAttribute("productService") Product product,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.select(1);
        productService.insert(product, employee);
        return "redirect:/product";
    }

}
