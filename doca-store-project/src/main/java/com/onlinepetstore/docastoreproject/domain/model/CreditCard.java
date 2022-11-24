package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CreditCard {
    int creditCardId;
    int cvvCvc;
    Date goodThru;
    int customerId;
}
