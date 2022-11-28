package com.onlinepetstore.docastoreproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepetstore.docastoreproject.domain.model.CategoryPet;
import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.domain.repository.CategoryPetDao;
import com.onlinepetstore.docastoreproject.domain.repository.EmployeeDao;

@Transactional
@Service
public class CategoryPetService {
    @Autowired
    @Qualifier("CategoryPetDaoIml")
    CategoryPetDao dao;
    EmployeeDao employeeDao;

    // insert a record
    public boolean insert(CategoryPet categoryPet, Employee employee) {

        int record = dao.insertRecord(categoryPet, employee);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    // select a row
    public CategoryPet select(int categoryPetId) {

        return dao.selectRecord(categoryPetId);
    }

    // select all
    public List<CategoryPet> selectAll() {
        return dao.selectAll();
    }

    // update a record
    public boolean update(CategoryPet categoryPet) {

        int record = dao.updateRecord(categoryPet);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    // delete a record
    public boolean delete(int categoryPetId) {

        int record = dao.deleteRecord(categoryPetId);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

}
