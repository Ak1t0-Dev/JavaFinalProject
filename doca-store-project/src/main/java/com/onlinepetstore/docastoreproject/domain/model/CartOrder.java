package com.onlinepetstore.docastoreproject.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CartOrder {
    private int cartOrderId;
    private int customerId;
    private Timestamp orderedAt;
    private BigDecimal total;
}
