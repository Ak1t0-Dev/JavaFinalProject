package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.Employee;

public interface EmployeeDao {

    // insert a record to employee table
    public int insertRecord(Employee employee) throws DataAccessException;

    // select a record from employee table
    public Employee selectRecord(int employeeId) throws DataAccessException;

    // select all records from employee table
    public List<Employee> selectAll() throws DataAccessException;

    // upate a record from employee table
    public int updateRecord(Employee employee) throws DataAccessException;

    // delete a record from employee table
    public int deleteRecord(int employeeId) throws DataAccessException;

}
