package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoryProduct {
    private int categoryProductId;
    @NotBlank
    @Size(max = 45)
    private String categoryName;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private int employeeRegisterId;
    private int employeeUpdateId;
}
