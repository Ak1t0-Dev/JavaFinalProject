package com.onlinepetstore.docastoreproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // insert a record
    @PostMapping("/insert")
    public String insert(@RequestBody Employee employee) {
        String result = "";
        if (employeeService.insert(employee))
            result = "insert is successful";
        else
            result = "insert is failed";
        return result;
    }

    // select a record
    @GetMapping("/select/{id:[0-9]+}")
    public Employee select(@PathVariable("id") int employeeId) {
        return employeeService.select(employeeId);
    }

    // select All
    @GetMapping
    public String selectAll(Model model) {
        List<Employee> employeeList = employeeService.selectAll();
        model.addAttribute("employeeList", employeeList);
        return "employee";
    }

    // update a record
    @PostMapping("/update")
    public String updateOne(@RequestBody Employee employee) {
        String result = "";
        if (employeeService.update(employee))
            result = "insert is successful";
        else
            result = "insert is failed";
        return result;
    }

    // delete a record
    @PostMapping("/delete/{id:.+}")
    public String delete(@PathVariable("id") int employeeId) {
        String result = "";
        if (employeeService.delete(employeeId))
        result = "insert is successful";
        else
            result = "insert is failed";
        return result;
    }
}
