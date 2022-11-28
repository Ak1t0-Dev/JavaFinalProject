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

import com.onlinepetstore.docastoreproject.domain.model.CategoryPet;
import com.onlinepetstore.docastoreproject.service.CategoryPetService;
import com.onlinepetstore.docastoreproject.service.EmployeeService;

@Controller
@RequestMapping("/categoryPet")
public class CategoryPetController {
    @Autowired
    CategoryPetService categoryPetService;
    EmployeeService employeeService;

    @GetMapping
    public String showData(Model model, @ModelAttribute("categoryPetService") CategoryPet categoryPet) {
        List<CategoryPet> categoryPetList = categoryPetService.selectAll();
        model.addAttribute("categoryPetList", categoryPetList);
        model.addAttribute("categoryPet", new CategoryPet());
        return "categoryPet";
    }

    @PostMapping("/insert")
    public String insert(Model model, @Validated @ModelAttribute("categoryPetService") CategoryPet categoryPet,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        categoryPetService.insert(categoryPet);
        return "redirect:/categoryPet";
    }

    @PostMapping("/update")
    public String update(Model model, @Validated @ModelAttribute("categoryPetService") CategoryPet categoryPet,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        categoryPetService.update(categoryPet);
        return "redirect:/categoryPet";
    }

    @PostMapping("/delete")
    public String delete(int categoryPetId) {
        categoryPetService.delete(categoryPetId);
        return "redirect:/categoryPet";
    }
}
