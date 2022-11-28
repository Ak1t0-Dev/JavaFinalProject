package com.onlinepetstore.docastoreproject.domain.repository.iml;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinepetstore.docastoreproject.domain.model.CategoryProduct;
import com.onlinepetstore.docastoreproject.domain.repository.CategoryProductDao;

@Repository("CategoryProductDaoIml")
public class CategoryProductDaoIml implements CategoryProductDao{

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to category_product table
    @Override
    public int insertRecord(CategoryProduct categoryProduct) throws DataAccessException {
        int row = jdbc.update(
            "INSERT INTO category_product (category_product_id, category_name, registered_at, updated_at, employee_register_id, employee_update_id) " + "VALUES (?, ?, ?, ?, ?, ?)",
            categoryProduct.getCategoryProductId(), categoryProduct.getCategoryName(), categoryProduct.getRegisteredAt(), categoryProduct.getUpdatedAt(), categoryProduct.getEmployeeRegisterId(), categoryProduct.getEmployeeUpdateId());
    return row;
    }

    // select a record from category_product table
    @Override
    public CategoryProduct selectRecord(int categoryProductId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM category_product " + "WHERE category_product_id = ?",
        categoryProductId);
        // An instance for a result
        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setCategoryProductId((Integer) map.get("category_product_id"));
        categoryProduct.setCategoryName((String) map.get("category_name"));
        categoryProduct.setRegisteredAt((Timestamp) map.get("registered_at"));
        categoryProduct.setUpdatedAt((Timestamp) map.get("updated_at"));
        categoryProduct.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
        categoryProduct.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
        return categoryProduct;
    }

    // select all records from category_product table
    @Override
    public List<CategoryProduct> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM category_product");
        List<CategoryProduct> categoryProductList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            CategoryProduct categoryProduct = new CategoryProduct();
            categoryProduct.setCategoryProductId((Integer) map.get("category_product_id"));
            categoryProduct.setCategoryName((String) map.get("category_name"));
            categoryProduct.setRegisteredAt((Timestamp) map.get("registered_at"));
            categoryProduct.setUpdatedAt((Timestamp) map.get("updated_at"));
            categoryProduct.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
            categoryProduct.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
            categoryProductList.add(categoryProduct);
        }
        return categoryProductList;
    }

     // upate a record from category_product table
    @Override
    public int updateRecord(CategoryProduct categoryProduct) throws DataAccessException {
        int row = jdbc.update(
            "UPDATE category_product " + "SET category_product_id = ?, category_name = ?, registered_at = ?, updated_at = ?, employee_register_id = ?, employee_update_id  = ?",
            categoryProduct.getCategoryProductId(), categoryProduct.getCategoryName(), categoryProduct.getRegisteredAt(), categoryProduct.getUpdatedAt(), categoryProduct.getEmployeeRegisterId(), categoryProduct.getEmployeeUpdateId());
            return row;
    }

    // delete a record from category_product table
    @Override
    public int deleteRecord(int categoryProductId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM category_product " + "WHERE category_product_id = ?");
        return row;
    }
    
}
