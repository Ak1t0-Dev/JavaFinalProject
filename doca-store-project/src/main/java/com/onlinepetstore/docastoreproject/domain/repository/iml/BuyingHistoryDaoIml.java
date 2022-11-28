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

import com.onlinepetstore.docastoreproject.domain.model.BuyingHistory;
import com.onlinepetstore.docastoreproject.domain.repository.BuyingHistoryDao;

@Repository("BuyingHistoryDaoIml")
public class BuyingHistoryDaoIml implements BuyingHistoryDao{

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to buying_history table
    @Override
    public int insertRecord(BuyingHistory buyingHistory) throws DataAccessException {
        int row = jdbc.update(
            "INSERT INTO buying_history (cart_order_id, customer_id, ordered_at, purchased_at, total) "
                    + "VALUES (?, ?, ?, ?, ?)",
            buyingHistory.getCartOrderId(), buyingHistory.getCustomerId(), buyingHistory.getOrderedAt(), buyingHistory.getPurchased_at(), buyingHistory.getTotal());
    return row;
    }

    // select a record from buying_history table
    @Override
    public BuyingHistory selectRecord(int cart_order_id) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM buying_history " + "WHERE cart_order_id = ?",
        cart_order_id);
        // An instance for a result
        BuyingHistory buyingHistory = new BuyingHistory();
        buyingHistory.setCartOrderId((Integer) map.get("cart_order_id"));
        buyingHistory.setCustomerId((Integer) map.get("customer_id"));
        buyingHistory.setOrderedAt((Timestamp) map.get("ordered_at"));
        buyingHistory.setPurchased_at((Timestamp) map.get("purchased_at"));
        buyingHistory.setTotal((BigDecimal) map. get("total"));
        return buyingHistory;
    }

   // select all records from buying_history table
    @Override
    public List<BuyingHistory> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM buying_history");
        List<BuyingHistory> buyingHistoryList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            BuyingHistory buyingHistory = new BuyingHistory();
            buyingHistory.setCartOrderId((Integer) map.get("cart_order_id"));
            buyingHistory.setCustomerId((Integer) map.get("customer_id"));
            buyingHistory.setOrderedAt((Timestamp) map.get("ordered_at"));
            buyingHistory.setPurchased_at((Timestamp) map.get("purchased_at"));
            buyingHistory.setTotal((BigDecimal) map. get("total"));
            buyingHistoryList.add(buyingHistory);
        }
        return buyingHistoryList;
    }

    // upate a record from buying_history table
    @Override
    public int updateRecord(BuyingHistory buyingHistory) throws DataAccessException {
        int row = jdbc.update(
            "UPDATE buying_history "
                    + "SET cart_order_id = ?, customer_id = ?, ordered_at = ?, purchased_at = ?, total = ?",
            buyingHistory.getCartOrderId(), buyingHistory.getCustomerId(), buyingHistory.getOrderedAt(), buyingHistory.getPurchased_at(), buyingHistory.getTotal());
    return row;
    }

    // delete a record from buying_history table
    @Override
    public int deleteRecord(int cart_order_id) throws DataAccessException {
        int row = jdbc.update("DELETE FROM buying_history " + "WHERE cart_order_id = ?");
        return row;
    }
    
}
