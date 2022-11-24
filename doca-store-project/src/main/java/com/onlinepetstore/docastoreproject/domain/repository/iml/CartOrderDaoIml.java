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

import com.onlinepetstore.docastoreproject.domain.model.CartOrder;
import com.onlinepetstore.docastoreproject.domain.repository.CartOrderDao;

@Repository("CartOrderDaoIml")
public class CartOrderDaoIml implements CartOrderDao {

    @Autowired
    JdbcTemplate jdbc;

    // insert a record to cart_order table
    @Override
    public int insertRecord(CartOrder cartOrder) throws DataAccessException {
        int row = jdbc.update(
                "INSERT INTO cart_order (cart_order_id, customer_id, ordered_at, total) " + "VALUES (?, ?, ?, ?)",
                cartOrder.getCartOrderId(), cartOrder.getCustomerId(), cartOrder.getOrderedAt(), cartOrder.getTotal());
        return row;
    }

    // select a record from cart_order table
    @Override
    public CartOrder selectRecord(int cartOrderId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM cart_order " + "WHERE cart_order_id = ?",
                cartOrderId);
        // An instance for a result
        CartOrder cartOrder = new CartOrder();
        cartOrder.setCartOrderId((Integer) map.get("cart_order_id"));
        cartOrder.setCustomerId((Integer) map.get("customer_id"));
        cartOrder.setOrderedAt((Timestamp) map.get("ordered_at"));
        cartOrder.setTotal((BigDecimal) map.get("total"));
        return cartOrder;
    }

    // select all records from cart_order table
    @Override
    public List<CartOrder> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM cart_order");
        List<CartOrder> cartOrderList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            CartOrder cartOrder = new CartOrder();
            cartOrder.setCartOrderId((Integer) map.get("cart_order_id"));
            cartOrder.setCustomerId((Integer) map.get("customer_id"));
            cartOrder.setOrderedAt((Timestamp) map.get("ordered_at"));
            cartOrder.setTotal((BigDecimal) map.get("total"));
            cartOrderList.add(cartOrder);
        }
        return cartOrderList;
    }

    // upate a record from cart_order table
    @Override
    public int updateRecord(CartOrder cartOrder) throws DataAccessException {
        int row = jdbc.update(
                "UPDATE cart_order " + "SET cart_order_id = ?, customer_id = ?, ordered_at = ?, total = ?",
                cartOrder.getCartOrderId(), cartOrder.getCustomerId(), cartOrder.getOrderedAt(), cartOrder.getTotal());
                return row;
    }

    // delete a record from cart_order table
    @Override
    public int deleteRecord(int cartOrderId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM cart_order " + "WHERE cart_order_id = ?");
        return row;
    }
}
