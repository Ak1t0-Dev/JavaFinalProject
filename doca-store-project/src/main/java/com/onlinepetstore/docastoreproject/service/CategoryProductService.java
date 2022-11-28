package com.onlinepetstore.docastoreproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepetstore.docastoreproject.domain.model.CategoryProduct;
import com.onlinepetstore.docastoreproject.domain.repository.CategoryProductDao;

@Transactional
@Service
public class CategoryProductService {

    @Autowired
    @Qualifier("CategoryProductDaoIml")
    CategoryProductDao dao;

    public boolean insert(CategoryProduct categoryProduct) {

        int record = dao.insertRecord(categoryProduct);
        boolean result = false;
        if (record > 0) {
            result = true;
        }
        return result;
    }

    public List<CategoryProduct> selectAll() {
        return dao.selectAll();
    }
}
