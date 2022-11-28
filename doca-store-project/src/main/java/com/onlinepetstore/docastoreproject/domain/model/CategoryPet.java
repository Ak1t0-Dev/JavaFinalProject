package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CategoryPet {
    @NotNull
    private int categoryPetId;
    @NotBlank
    @NotNull
    private String categoryName;
    @NotNull
    private Timestamp registeredAt;
    @NotNull
    private Timestamp updatedAt;
    @NotNull
    private int employeeRegisterId;
    @NotNull
    private int employeeUpdateId;
}
