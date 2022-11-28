package com.onlinepetstore.docastoreproject.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BuyingHistory {
    private int cartOrderId;
    private int customerId;
    private Timestamp orderedAt;
    private Timestamp purchased_at;
    private BigDecimal total;
}