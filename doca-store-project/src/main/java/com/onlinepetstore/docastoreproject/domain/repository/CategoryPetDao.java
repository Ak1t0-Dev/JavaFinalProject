package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.CategoryPet;
import com.onlinepetstore.docastoreproject.domain.model.Employee;

public interface CategoryPetDao {

    // insert a record to category_pet table
    public int insertRecord(CategoryPet categoryPet, Employee employee) throws DataAccessException;

    // select a record from category_pet table
    public CategoryPet selectRecord(int categoryPetId) throws DataAccessException;

    // select all records from category_pet table
    public List<CategoryPet> selectAll() throws DataAccessException;

    // upate a record from category_pet table
    public int updateRecord(CategoryPet categoryPet, Employee employee) throws DataAccessException;

    // delete a record from category_pet table
    public int deleteRecord(int categoryPetId) throws DataAccessException;

}
