package com.onlinepetstore.docastoreproject.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinepetstore.docastoreproject.domain.model.Product;
import com.onlinepetstore.docastoreproject.service.ProductService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping
    public String home() {
        return "store/home";
    }

    @GetMapping
    @RequestMapping("/product")
    public String product(Model model) {
        List<Product> productList = productService.selectAll();
        model.addAttribute("productList", productList);
        return "store/product";
    }

}
