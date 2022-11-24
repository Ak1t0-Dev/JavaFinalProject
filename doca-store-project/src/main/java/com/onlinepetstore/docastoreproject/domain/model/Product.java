package com.onlinepetstore.docastoreproject.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private BigDecimal unitPrice;
    private int categoryProductId;
    private int categoryPetId;
    private String image;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private int employeeRegisterId;
    private int employeeUpdateId;
}
