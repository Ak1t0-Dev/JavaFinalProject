package com.onlinepetstore.docastoreproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.domain.repository.EmployeeDao;

@Transactional
@Service
public class EmployeeService {
    @Autowired
    @Qualifier("EmployeeDaoIml")
    EmployeeDao dao;

    // insert a record
    public boolean insert(Employee employee) {

        int record = dao.insertRecord(employee);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    // select a row
    public Employee select(int employeeId) {

        return dao.selectRecord(employeeId);
    }

    // select all
    public List<Employee> selectAll() {
        return dao.selectAll();
    }

    // update a record
    public boolean update(Employee employee) {

        int record = dao.updateRecord(employee);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    // delete a record
    public boolean delete(int employeeId) {

        int record = dao.deleteRecord(employeeId);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

}
