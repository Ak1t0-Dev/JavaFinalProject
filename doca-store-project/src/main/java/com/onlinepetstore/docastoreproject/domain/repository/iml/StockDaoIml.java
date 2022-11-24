package com.onlinepetstore.docastoreproject.domain.repository.iml;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinepetstore.docastoreproject.domain.model.Stock;
import com.onlinepetstore.docastoreproject.domain.repository.StockDao;

@Repository("StockDaoIml")
public class StockDaoIml implements StockDao {

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to stock table
    public int insertRecord(Stock stock) throws DataAccessException {
        int row = jdbc.update(
                "INSERT INTO stock (product_id, quantity, registered_at, updated_at, employee_register_id, employee_update_id) "
                        + "VALUES (?, ?, ?, ?, ?, ?)",
                stock.getProductId(), stock.getQuantity(), stock.getRegisteredAt(), stock.getUpdatedAt(),
                stock.getEmployeeRegisterId(), stock.getEmployeeUpdateId());
        return row;
    }

    // select a record from stock table
    public Stock selectRecord(int productId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM stock " + "WHERE product_id = ?",
                productId);
        // An instance for a result
        Stock stock = new Stock();
        stock.setProductId((Integer) map.get("product_id"));
        stock.setQuantity((Integer) map.get("quantity"));
        stock.setRegisteredAt((Timestamp) map.get("registered_at"));
        stock.setUpdatedAt((Timestamp) map.get("updated_at"));
        stock.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
        stock.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
        return stock;
    }

    // select all records from stock table
    public List<Stock> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM stock");
        List<Stock> stockList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            Stock stock = new Stock();
            stock.setProductId((Integer) map.get("product_id"));
            stock.setQuantity((Integer) map.get("quantity"));
            stock.setRegisteredAt((Timestamp) map.get("registered_at"));
            stock.setUpdatedAt((Timestamp) map.get("updated_at"));
            stock.setEmployeeRegisterId((Integer) map.get("employee_register_id"));
            stock.setEmployeeUpdateId((Integer) map.get("employee_update_id"));
            stockList.add(stock);
        }
        return stockList;
    }

    // upate a record from stock table
    public int updateRecord(Stock stock) throws DataAccessException {
        int row = jdbc.update(
                "UPDATE stock "
                        + "SET product_id = ?, quantity = ?, registered_at = ?, updated_at = ?, employee_register_id = ?, employee_update_id = ?",
                stock.getProductId(), stock.getQuantity(), stock.getRegisteredAt(), stock.getUpdatedAt(),
                stock.getEmployeeRegisterId(), stock.getEmployeeUpdateId());
        return row;
    }

    // delete a record from stock table
    public int deleteRecord(int productId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM stock " + "WHERE product_id = ?");
        return row;
    }

}
