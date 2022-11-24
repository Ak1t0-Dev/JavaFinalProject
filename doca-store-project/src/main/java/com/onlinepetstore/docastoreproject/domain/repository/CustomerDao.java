package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.Customer;

public interface CustomerDao {

    // insert a record to customer table
    public int insertRecord(Customer customer) throws DataAccessException;

    // select a record from customer table
    public Customer selectRecord(int customerId) throws DataAccessException;

    // select all records from customer table
    public List<Customer> selectAll() throws DataAccessException;

    // upate a record from customer table
    public int updateRecord(Customer customer) throws DataAccessException;

    // delete a record from customer table
    public int deleteRecord(int customerId) throws DataAccessException;

}
