package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Stock {
    private int productId;
    private int quantity;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private int employeeRegisterId;
    private int employeeUpdateId;
}
