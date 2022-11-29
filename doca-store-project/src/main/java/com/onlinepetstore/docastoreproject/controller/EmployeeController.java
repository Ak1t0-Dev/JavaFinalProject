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

import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // show data
    @GetMapping
    public String showData(Model model, @ModelAttribute("employee") Employee empolyee) {
        List<Employee> employeeList = employeeService.selectAll();
        model.addAttribute("employeeList", employeeList);
        return "employee";
    }

    @PostMapping("/insert")
    public String insert(Model model, @Validated @ModelAttribute("employee") Employee employee, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return showData(model, employee);
        }
        employeeService.insert(employee);

        return "redirect:/employee";
    }

    // select a record
    // @GetMapping("/select/{id:[0-9]+}")
    // public Employee select(@PathVariable("id") int employeeId) {
    // return employeeService.select(employeeId);
    // }

    // update a record
    @PostMapping("/update")
    public String update(Model model, @Validated @ModelAttribute("employee") Employee employee, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return showData(model, employee);
        }
        employeeService.update(employee);
        return "redirect:/employee";
    }

    // delete a record
    @PostMapping("/delete")
    public String delete(int employeeId) {
        employeeService.delete(employeeId);
        return "redirect:/employee";
    }
}
