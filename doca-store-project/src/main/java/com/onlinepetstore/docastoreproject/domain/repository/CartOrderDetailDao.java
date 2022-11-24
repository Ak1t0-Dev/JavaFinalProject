package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.CartOrderDetail;

public interface CartOrderDetailDao {

    // insert a record to cart_order_detail table
    public int insertRecord(CartOrderDetail cartOrderDetail) throws DataAccessException;

    // select a record from cart_order_detail table
    public CartOrderDetail selectRecord(int cartOrderDetailId) throws DataAccessException;

    // select all records from cart_order_detail table
    public List<CartOrderDetail> selectAll() throws DataAccessException;

    // upate a record from cart_order_detail table
    public int updateRecord(CartOrderDetail cartOrderDetail) throws DataAccessException;

    // delete a record from cart_order_detail table
    public int deleteRecord(int cartOrderDetailId) throws DataAccessException;

}
