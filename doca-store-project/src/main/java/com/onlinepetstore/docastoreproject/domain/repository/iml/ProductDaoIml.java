package com.onlinepetstore.docastoreproject.domain.repository.iml;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinepetstore.docastoreproject.domain.model.Product;
import com.onlinepetstore.docastoreproject.domain.repository.ProductDao;

@Repository("ProductDaoIml")
public class ProductDaoIml implements ProductDao {

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to product table
    @Override
    public int insertRecord(Product product) throws DataAccessException {
        int row = jdbc.update(
                "INSERT INTO product (product_id, product_name, unit_price, category_product_id, category_pet_id, image, registered_at, updated_at, employee_register_id, employee_update_id) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                product.getProductId(), product.getProductName(), product.getUnitPrice(),
                product.getCategoryProductId(), product.getCategoryPetId(), product.getImage(),
                product.getRegisteredAt(), product.getUpdatedAt(), product.getEmployeeRegisterId(),
                product.getEmployeeUpdateId());
        return row;
    }

    // select a record from product table
    @Override
    public Product selectRecord(int productId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM product " + "WHERE product_id = ?",
                productId);
        // An instance for a result
        Product product = new Product();
        product.setProductId((Integer) map.get("product_id"));
        product.setProductName((String) map.get("product_name"));
        product.setUnitPrice((BigDecimal) map.get("unit_price"));
        product.setCategoryProductId((Integer) map.get("category_product_id"));
        product.setCategoryPetId((Integer) map.get("category_pet_id"));
        product.setImage((String) map.get("image"));
        product.setRegisteredAt((Timestamp) map.get("registered_at"));
        product.setUpdatedAt((Timestamp) map.get("updated_at"));
        product.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
        product.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
        return product;
    }

    // select all records from product table
    @Override
    public List<Product> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM product");
        List<Product> productList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            Product product = new Product();
            product.setProductId((Integer) map.get("product_id"));
            product.setProductName((String) map.get("product_name"));
            product.setUnitPrice((BigDecimal) map.get("unit_price"));
            product.setCategoryProductId((Integer) map.get("category_product_id"));
            product.setCategoryPetId((Integer) map.get("category_pet_id"));
            product.setImage((String) map.get("image"));
            product.setRegisteredAt((Timestamp) map.get("registered_at"));
            product.setUpdatedAt((Timestamp) map.get("updated_at"));
            product.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
            product.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
            productList.add(product);
        }
        return productList;
    }

    // upate a record from product table
    @Override
    public int updateRecord(Product product) throws DataAccessException {
        int row = jdbc.update(
                "UPDATE product "
                        + "SET product_id = ?, product_name = ?, unit_price = ?, category_product_id = ?, category_pet_id = ?, image = ?, registered_at = ?, updated_at = ?, employee_register_id = ?, employee_update_id = ?",
                product.getProductId(), product.getProductName(), product.getUnitPrice(), product.getCategoryProductId(),
                product.getCategoryPetId(), product.getImage(), product.getRegisteredAt(), product.getUpdatedAt(),
                product.getEmployeeRegisterId(), product.getEmployeeUpdateId());
        return row;
    }

    // delete a record from product table
    @Override
    public int deleteRecord(int productId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM product " + "WHERE product_id = ?");
        return row;
    }

}
