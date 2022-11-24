package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.Product;

public interface ProductDao {

    // insert a record to product table
    public int insertRecord(Product product) throws DataAccessException;

    // select a record from product table
    public Product selectRecord(int productId) throws DataAccessException;

    // select all records from product table
    public List<Product> selectAll() throws DataAccessException;

    // upate a record from product table
    public int updateRecord(Product product) throws DataAccessException;

    // delete a record from product table
    public int deleteRecord(int productId) throws DataAccessException;

}
