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

import com.onlinepetstore.docastoreproject.domain.model.Employee;
import com.onlinepetstore.docastoreproject.domain.repository.EmployeeDao;

@Repository("EmployeeDaoIml")
public class EmployeeDaoIml implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to employee table
    public int insertRecord(Employee employee) throws DataAccessException {
        int row = jdbc.update(
                "INSERT INTO employee (employee_id, first_name, last_name, born_date, phone_number, email_address, address, administrator, password, registered_at, updated_at) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
                employee.getBornDate(), employee.getPhoneNumber(), employee.getEmailAddress(),
                employee.getAddress(), employee.isAdministrator(), employee.getPassword(),
                employee.getRegisteredAt(), employee.getUpdatedAt(), employee.getEmployeeRegisterId(),
                employee.getEmployeeUpdateId());
        return row;
    }

    // select a record from employee table
    public Employee selectRecord(int employeeId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM employee " + "WHERE employee_id = ?",
                employeeId);
        // An instance for a result
        Employee employee = new Employee();
        employee.setEmployeeId((Integer) map.get("employee_id"));
        employee.setFirstName((String) map.get("first_name"));
        employee.setLastName((String) map.get("last_name"));
        employee.setBornDate((Date) map.get("born_date"));
        employee.setPhoneNumber((String) map.get("phone_number"));
        employee.setEmailAddress((String) map.get("email_address"));
        employee.setAddress((String) map.get("address"));
        employee.setAdministrator((Boolean) map.get("administrator"));
        employee.setPassword((String) map.get("password"));
        employee.setRegisteredAt((Timestamp) map.get("registered_at"));
        employee.setUpdatedAt((Timestamp) map.get("updated_at"));
        employee.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
        employee.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
        return employee;
    }

    // select all records from employee table
    public List<Employee> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM employee");
        List<Employee> employeeList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            Employee employee = new Employee();
            employee.setEmployeeId((Integer) map.get("employee_id"));
            employee.setFirstName((String) map.get("first_name"));
            employee.setLastName((String) map.get("last_name"));
            employee.setBornDate((Date) map.get("born_date"));
            employee.setPhoneNumber((String) map.get("phone_number"));
            employee.setEmailAddress((String) map.get("email_address"));
            employee.setAddress((String) map.get("address"));
            employee.setAdministrator((Boolean) map.get("administrator"));
            employee.setPassword((String) map.get("password"));
            employee.setRegisteredAt((Timestamp) map.get("registered_at"));
            employee.setUpdatedAt((Timestamp) map.get("updated_at"));
            employee.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
            employee.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
            employeeList.add(employee);
        }
        return employeeList;
    }

    // upate a record from employee table
    public int updateRecord(Employee employee) throws DataAccessException {
        int row = jdbc.update(
                "UPDATE employee "
                        + "SET employee_id = ?, first_name = ?, last_name = ?, born_date = ?, phone_number = ?, email_address = ?, address = ?, administrator = ?, password = ?, registered_at = ?, updated_at = ?, employee_register_id = ?, employee_update_id = ?",
                employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getBornDate(),
                employee.getPhoneNumber(), employee.getEmailAddress(), employee.getAddress(),
                employee.isAdministrator(), employee.getRegisteredAt(),
                employee.getUpdatedAt(), employee.getEmployeeRegisterId(),
                employee.getEmployeeUpdateId());
        return row;
    }

    // delete a record from employee table
    public int deleteRecord(int employeeId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM employee " + "WHERE employee_id = ?");
        return row;
    }

}
