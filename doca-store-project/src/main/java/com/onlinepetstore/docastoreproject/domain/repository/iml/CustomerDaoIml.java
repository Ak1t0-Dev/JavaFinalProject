package com.onlinepetstore.docastoreproject.domain.repository.iml;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinepetstore.docastoreproject.domain.model.Customer;
import com.onlinepetstore.docastoreproject.domain.repository.CustomerDao;

@Repository("CustomerDaoIml")
public class CustomerDaoIml implements CustomerDao {
    
    @Autowired
    JdbcTemplate jdbc;

    // insert a record to customer table
    public int insertRecord(Customer customer) throws DataAccessException {
        int row = jdbc.update(
                "INSERT INTO customer (customer_id, first_name, last_name, born_date, phone_number, email_address, address, password, registered_at, updated_at) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
                customer.getBornDate(), customer.getPhoneNumber(), customer.getEmailAddress(),
                customer.getAddress(), customer.getPassword(),
                customer.getRegisteredAt(), customer.getUpdatedAt());
        return row;
    }

    // select a record from customer table
    public Customer selectRecord(int customerId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM customer " + "WHERE customer_id = ?",
                customerId);
        // An instance for a result
        Customer customer = new Customer();
        customer.setCustomerId((Integer) map.get("customer_id"));
        customer.setFirstName((String) map.get("first_name"));
        customer.setLastName((String) map.get("last_name"));
        customer.setBornDate((Date) map.get("born_date"));
        customer.setPhoneNumber((String) map.get("phone_number"));
        customer.setEmailAddress((String) map.get("email_address"));
        customer.setAddress((String) map.get("address"));
        customer.setPassword((String) map.get("password"));
        customer.setRegisteredAt((Timestamp) map.get("registered_at"));
        customer.setUpdatedAt((Timestamp) map.get("updated_at"));
        return customer;
    }

    // select all records from customer table
    public List<Customer> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM customer");
        List<Customer> customerList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            Customer customer = new Customer();
            customer.setCustomerId((Integer) map.get("customer_id"));
            customer.setFirstName((String) map.get("first_name"));
            customer.setLastName((String) map.get("last_name"));
            customer.setBornDate((Date) map.get("born_date"));
            customer.setPhoneNumber((String) map.get("phone_number"));
            customer.setEmailAddress((String) map.get("email_address"));
            customer.setAddress((String) map.get("address"));
            customer.setPassword((String) map.get("password"));
            customer.setRegisteredAt((Timestamp) map.get("registered_at"));
            customer.setUpdatedAt((Timestamp) map.get("updated_at"));
            customerList.add(customer);
        }
        return customerList;
    }

    // upate a record from customer table
    public int updateRecord(Customer customer) throws DataAccessException {
        int row = jdbc.update(
                "UPDATE customer "
                        + "SET customer_id = ?, first_name = ?, last_name = ?, born_date = ?, phone_number = ?, email_address = ?, password = ?, registered_at = ?, updated_at = ?, employee_register_id = ?, employee_update_id = ?",
                        customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
                        customer.getBornDate(), customer.getPhoneNumber(), customer.getEmailAddress(),
                        customer.getAddress(), customer.getPassword(),
                        customer.getRegisteredAt(), customer.getUpdatedAt());
        return row;
    }

    // delete a record from customer table
    public int deleteRecord(int customerId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM customer " + "WHERE customer_id = ?");
        return row;
    }

}
