package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class Employee {

    @NotNull
    private int employeeId;
    @NotBlank
    @Size(max = 2)
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 45)
    private String lastName;
    @NotNull
    private Date bornDate;
    @NotBlank
    @Size(min = 1, max = 20)
    private String phoneNumber;
    @NotBlank
    @Size(min = 1, max = 45)
    private String emailAddress;
    @NotBlank
    @Size(min = 1, max = 45)
    private String address;
    @NotNull
    private boolean administrator;
    @NotBlank
    @Size(min = 1, max = 100)
    private String password;
    @NotNull
    private Timestamp registeredAt;
    @NotNull
    private Timestamp updatedAt;
    @NotNull
    private int employeeRegisterId;
    @NotNull
    private int employeeUpdateId;
}
