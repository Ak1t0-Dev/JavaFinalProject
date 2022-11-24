package com.onlinepetstore.docastoreproject.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartOrderDetail {
    private int cartOrderDetailId;
    private int cartOrderId;
    private int productId;
    private int orderedAt;
    private BigDecimal unitPrice;
    private int quantity;
}
