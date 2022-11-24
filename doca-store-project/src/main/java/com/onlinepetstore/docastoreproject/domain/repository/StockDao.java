package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.Stock;

public interface StockDao {

    // insert a record to stock table
    public int insertRecord(Stock stock) throws DataAccessException;

    // select a record from stock table
    public Stock selectRecord(int productId) throws DataAccessException;

    // select all records from stock table
    public List<Stock> selectAll() throws DataAccessException;

    // upate a record from stock table
    public int updateRecord(Stock stock) throws DataAccessException;

    // delete a record from stock table
    public int deleteRecord(int productId) throws DataAccessException;
  
}
