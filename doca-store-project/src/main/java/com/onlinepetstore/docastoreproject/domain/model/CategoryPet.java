package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CategoryPet {
    private int categoryPetId;
    private String categoryName;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private int employeeRegisterId;
    private int employeeUpdateId;
}
