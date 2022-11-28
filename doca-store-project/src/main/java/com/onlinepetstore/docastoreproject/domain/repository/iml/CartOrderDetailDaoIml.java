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

import com.onlinepetstore.docastoreproject.domain.model.CartOrderDetail;
import com.onlinepetstore.docastoreproject.domain.repository.CartOrderDetailDao;

@Repository("CartOrderDetailDaoIml")
public class CartOrderDetailDaoIml implements CartOrderDetailDao{

    @Autowired
    JdbcTemplate jdbc;
    
    // insert a record to cart_order_detail table  
    @Override
    public int insertRecord(CartOrderDetail cartOrderDetail) throws DataAccessException {
        int row = jdbc.update(
                "INSERT INTO cart_order_detail (cart_order_detail_id, cart_order_id, product_id, ordered_at, unit_price, quantity) " + "VALUES (?, ?, ?, ?, ?, ?)",
                cartOrderDetail.getCartOrderDetailId(), cartOrderDetail.getCartOrderId(), cartOrderDetail.getProductId(), cartOrderDetail.getOrderedAt(), cartOrderDetail.getUnitPrice(), cartOrderDetail.getQuantity());
        return row;
    }

    // select a record from cart_order_detail table
    @Override
    public CartOrderDetail selectRecord(int cartOrderDetailId) throws DataAccessException {
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM cart_order_detail " + "WHERE cart_order_detail_id = ?",
        cartOrderDetailId);
        // An instance for a result
        CartOrderDetail cartOrderDetail = new CartOrderDetail();
        cartOrderDetail.setCartOrderDetailId((Integer) map.get("cart_order_deetail_id"));
        cartOrderDetail.setCartOrderId((Integer) map.get("cart_order_id"));
        cartOrderDetail.setProductId((Integer) map.get("product_id"));
        cartOrderDetail.setOrderedAt((Timestamp) map.get("ordered_at"));
        cartOrderDetail.setUnitPrice((BigDecimal) map.get("unit_price"));
        cartOrderDetail.setQuantity((Integer) map.get("quantity"));
        return cartOrderDetail;
    }

     // select all records from cart_order_detail table    
    @Override
    public List<CartOrderDetail> selectAll() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM cart_order_detail");
        List<CartOrderDetail> cartOrderDetailList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            // An instance for a result
            CartOrderDetail cartOrderDetail = new CartOrderDetail();
            cartOrderDetail.setCartOrderDetailId((Integer) map.get("cart_order_deetail_id"));
            cartOrderDetail.setCartOrderId((Integer) map.get("cart_order_id"));
            cartOrderDetail.setProductId((Integer) map.get("product_id"));
            cartOrderDetail.setOrderedAt((Timestamp) map.get("ordered_at"));
            cartOrderDetail.setUnitPrice((BigDecimal) map.get("unit_price"));
            cartOrderDetail.setQuantity((Integer) map.get("quantity"));
            cartOrderDetailList.add(cartOrderDetail);
        }
        return cartOrderDetailList;
    }

    // upate a record from cart_order_detail table
    @Override
    public int updateRecord(CartOrderDetail cartOrderDetail) throws DataAccessException {
        int row = jdbc.update(
            "UPDATE cart_order_detail " + "SET cart_order_detail_id = ?, cart_order_id = ?, product_id = ?, ordered_at = ?, unit_price = ?, quantity  = ?",
            cartOrderDetail.getCartOrderDetailId(), cartOrderDetail.getCartOrderId(), cartOrderDetail.getProductId(), cartOrderDetail.getOrderedAt(), cartOrderDetail.getUnitPrice(), cartOrderDetail.getQuantity());
            return row;
    }

   // delete a record from cart_order_detail table
    @Override
    public int deleteRecord(int cartOrderDetailId) throws DataAccessException {
        int row = jdbc.update("DELETE FROM cart_order_detail " + "WHERE cart_order_detail_id = ?");
        return row;
    }
    
}
