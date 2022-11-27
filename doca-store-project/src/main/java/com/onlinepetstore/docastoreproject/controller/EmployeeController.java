package com.onlinepetstore.docastoreproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // show data
    @GetMapping
    public String showData(Model model, Employee empolyee) {
        List<Employee> employeeList = employeeService.selectAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("newemployee", new Employee());
        return "employee";
    }

    @PostMapping("/insert")
    public String insert(Employee employee) {
        employeeService.insert(employee);
        return "redirect:/employee";
    }

    // select a record
    // @GetMapping("/select/{id:[0-9]+}")
    // public Employee select(@PathVariable("id") int employeeId) {
    //     return employeeService.select(employeeId);
    // }

    // update a record
    @PostMapping("/update")
    public String update(Employee employee) {
        employeeService.update(employee);
        // String result = "";
        // if (employeeService.update(employee))
        //     result = "insert is successful";
        // else
        //     result = "insert is failed";
        return "redirect:/employee";
    }

    // delete a record
    @PostMapping("/delete")
    public String delete(int employeeId) {
        employeeService.delete(employeeId);
        return "redirect:/employee";
    }
}
