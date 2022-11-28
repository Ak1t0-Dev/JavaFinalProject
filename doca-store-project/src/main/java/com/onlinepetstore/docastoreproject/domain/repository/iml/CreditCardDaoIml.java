package com.onlinepetstore.docastoreproject.domain.repository.iml;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinepetstore.docastoreproject.domain.model.CreditCard;
import com.onlinepetstore.docastoreproject.domain.repository.CreditCardDao;

@Repository("CreditCardDaoIml")
public class CreditCardDaoIml implements CreditCardDao {

@Autowired
JdbcTemplate jdbc;

// insert a record to credit_card table
@Override
public int insertRecord(CreditCard creditCard) throws DataAccessException {
    int row = jdbc.update(
        "INSERT INTO product (credit_card_id, cvv_cvc, good_thru, customer_id) "
                + "VALUES (?, ?, ?, ?)",
        creditCard.getCreditCardId(), creditCard.getCvvCvc(), creditCard.getGoodThru(), creditCard.getCustomerId());
return row;
}


// select a record from credit_card table
@Override
public CreditCard selectRecord(int creditCardId) throws DataAccessException {
    Map<String, Object> map = jdbc.queryForMap("SELECT * FROM credit_card " + "WHERE credit_card_id = ?",
    creditCardId);
    // An instance for a result
    CreditCard creditCard = new CreditCard();
    creditCard.setCreditCardId((Integer) map.get("credit_card_id"));
    creditCard.setCvvCvc((Integer) map.get("cvv_cvc"));
    creditCard.setGoodThru((Date) map.get("good_thru"));
    creditCard.setCustomerId((Integer) map.get("customer_id"));
    return creditCard;
}

 // select all records from credit_card table
@Override
public List<CreditCard> selectAll() throws DataAccessException {
    List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM credit_card");
    List<CreditCard> creditCardList = new ArrayList<>();
    for (Map<String, Object> map : getList) {
        // An instance for a result
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardId((Integer) map.get("credit_card_id"));
        creditCard.setCvvCvc((Integer) map.get("cvv_cvc"));
        creditCard.setGoodThru((Date) map.get("good_thru"));
        creditCard.setCustomerId((Integer) map.get("customer_id"));
        creditCardList.add(creditCard);
    }
    return creditCardList;
}

// upate a record from credit_card table
@Override
public int updateRecord(CreditCard creditCard) throws DataAccessException {
    int row = jdbc.update(
        "UPDATE credit_card "
                + "SET credit_card_id = ?, cvv_cvc = ?, good_thru = ?, customer_id = ?",
        creditCard.getCreditCardId(), creditCard.getCvvCvc(), creditCard.getGoodThru(), creditCard.getCustomerId());
return row;
}

 // delete a record from credit_card table
@Override
public int deleteRecord(int creditCardId) throws DataAccessException {
    int row = jdbc.update("DELETE FROM credit_card " + "WHERE credit_card_id = ?");
    return row;
}
    
}
