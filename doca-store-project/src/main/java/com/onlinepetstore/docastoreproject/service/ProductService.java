package com.onlinepetstore.docastoreproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.domain.model.Product;
import com.onlinepetstore.docastoreproject.domain.repository.ProductDao;

@Transactional
@Service
public class ProductService {

    @Autowired
    @Qualifier("ProductDaoIml")
    ProductDao dao;

    public boolean insert(Product product, Employee employee) {

        int record = dao.insertRecord(product, employee);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    public List<Product> selectAll() {
        return dao.selectAll();
    }

}
