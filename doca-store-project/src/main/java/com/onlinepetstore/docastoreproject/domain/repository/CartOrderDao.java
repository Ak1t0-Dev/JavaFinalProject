package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.CartOrder;

public interface CartOrderDao {

    // insert a record to cart_order table
    public int insertRecord(CartOrder cartOrder) throws DataAccessException;

    // select a record from cart_order table
    public CartOrder selectRecord(int cartOrderId) throws DataAccessException;

    // select all records from cart_order table
    public List<CartOrder> selectAll() throws DataAccessException;

    // upate a record from cart_order table
    public int updateRecord(CartOrder cartOrder) throws DataAccessException;

    // delete a record from cart_order table
    public int deleteRecord(int cartOrderId) throws DataAccessException;

}
