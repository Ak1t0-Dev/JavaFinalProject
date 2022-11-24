package com.onlinepetstore.docastoreproject.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.onlinepetstore.docastoreproject.domain.model.CreditCard;

public interface CreditCardDao {

    // insert a record to credit_card table
    public int insertRecord(CreditCard creditCard) throws DataAccessException;

    // select a record from credit_card table
    public CreditCard selectRecord(int creditCardId) throws DataAccessException;

    // select all records from credit_card table
    public List<CreditCard> selectAll() throws DataAccessException;

    // upate a record from credit_card table
    public int updateRecord(CreditCard creditCard) throws DataAccessException;

    // delete a record from credit_card table
    public int deleteRecord(int creditCardId) throws DataAccessException;

}
