package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.BuyingHistory;

public interface BuyingHistoryDao {
    

    // insert a record to buying_history table
    public int insertRecord(BuyingHistory buyingHistory) throws DataAccessException;

    // select a record from cart_order table
    public BuyingHistory selectRecord(int cart_order_id) throws DataAccessException;

    // select all records from cart_order table
    public List<BuyingHistory> selectAll() throws DataAccessException;

    // upate a record from cart_order table
    public int updateRecord(BuyingHistory buyingHistory) throws DataAccessException;

    // delete a record from cart_order table
    public int deleteRecord(int cart_order_id) throws DataAccessException;    
}
