package com.onlinepetstore.docastoreproject.domain.repository.iml;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinepetstore.docastoreproject.domain.model.CategoryPet;
import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.domain.repository.CategoryPetDao;

@Repository("CategoryPetDaoIml")
public class CategoryPetDaoIml implements CategoryPetDao {

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to category_pet table
    @Override
    public int insertRecord(CategoryPet categoryPet, Employee employee) throws DataAccessException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int row = jdbc.update(
                "INSERT INTO category_pet (category_pet_id, category_name, registered_at, updated_at, employee_register_id, employee_update_id) "
                        + "VALUES (?, ?, ?, ?, ?, ?)",
                categoryPet.getCategoryPetId(), categoryPet.getCategoryName(),
                timestamp, timestamp,
                employee.getEmployeeId(), employee.getEmployeeId());
        return row;
    }

    // select a record from category_pet table
    @Override
    public CategoryPet selectRecord(int categoryPetId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM category_pet " + "WHERE category_pet_id = ?",
                categoryPetId);
        // An instance for a result
        CategoryPet categoryPet = new CategoryPet();
        categoryPet.setCategoryPetId((Integer) map.get("category_pet_id"));
        categoryPet.setCategoryName((String) map.get("category_name"));
        categoryPet.setRegisteredAt((Timestamp) map.get("registered_at"));
        categoryPet.setUpdatedAt((Timestamp) map.get("updated_at"));
        categoryPet.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
        categoryPet.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
        return categoryPet;
    }

    // select all records from category_pet table
    @Override
    public List<CategoryPet> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM category_pet");
        List<CategoryPet> categoryPetList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            CategoryPet categoryPet = new CategoryPet();
            categoryPet.setCategoryPetId((Integer) map.get("category_pet_id"));
            categoryPet.setCategoryName((String) map.get("category_name"));
            categoryPet.setRegisteredAt((Timestamp) map.get("registered_at"));
            categoryPet.setUpdatedAt((Timestamp) map.get("updated_at"));
            categoryPet.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
            categoryPet.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
            categoryPetList.add(categoryPet);
        }
        return categoryPetList;
    }

    // upate a record from category_pet table
    @Override
    public int updateRecord(CategoryPet categoryPet) throws DataAccessException {
        int row = jdbc.update(
                "UPDATE category_pet "
                        + "SET category_pet_id = ?, category_name = ?, registered_at = ?, updated_at = ?, employee_register_id = ?, employee_update_id  = ?",
                categoryPet.getCategoryPetId(), categoryPet.getCategoryName(), categoryPet.getRegisteredAt(),
                categoryPet.getUpdatedAt(), categoryPet.getEmployeeRegisterId(), categoryPet.getEmployeeUpdateId());
        return row;
    }

    // delete a record from category_pet table
    @Override
    public int deleteRecord(int categoryPetId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM category_pet " + "WHERE category_pet_id = ?");
        return row;
    }

}
