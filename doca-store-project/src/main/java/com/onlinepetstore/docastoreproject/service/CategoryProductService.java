package com.onlinepetstore.docastoreproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepetstore.docastoreproject.domain.model.CategoryProduct;
import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.domain.repository.CategoryProductDao;

@Transactional
@Service
public class CategoryProductService {

    @Autowired
    @Qualifier("CategoryProductDaoIml")
    CategoryProductDao dao;

    // insert a record
    public boolean insert(CategoryProduct categoryProduct, Employee employee) {

        int record = dao.insertRecord(categoryProduct, employee);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    // select a row
    public CategoryProduct select(int categoryProductId) {

        return dao.selectRecord(categoryProductId);
    }

    // select all
    public List<CategoryProduct> selectAll() {
        return dao.selectAll();
    }

    // update a record
    public boolean update(CategoryProduct categoryProduct, Employee employee) {

        int record = dao.updateRecord(categoryProduct, employee);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    // delete a record
    public boolean delete(int categoryProductId) {

        int record = dao.deleteRecord(categoryProductId);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }
}
