package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.CategoryProduct;

public interface CategoryProductDao {

    // insert a record to category_product table
    public int insertRecord(CategoryProduct categoryProduct) throws DataAccessException;

    // select a record from category_product table
    public CategoryProduct selectRecord(int categoryProductId) throws DataAccessException;

    // select all records from category_product table
    public List<CategoryProduct> selectAll() throws DataAccessException;

    // upate a record from category_product table
    public int updateRecord(CategoryProduct categoryProduct) throws DataAccessException;

    // delete a record from category_product table
    public int deleteRecord(int categoryProductId) throws DataAccessException;
   
}
