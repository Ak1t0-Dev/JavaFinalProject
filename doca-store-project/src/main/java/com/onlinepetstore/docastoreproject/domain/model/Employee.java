package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
// @Table(name = "employee")
public class Employee {

    // @Column(value = "employeeid")
    @NotNull
    private int employeeId;
    @NotNull
    @Size(min = 1, max = 45)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 45)
    private String lastName;
    @NotNull
    private Date bornDate;
    @NotNull
    @Size(min = 1, max = 20)
    private String phoneNumber;
    @NotNull
    @Size(min = 1, max = 45)
    private String emailAddress;
    @NotNull
    @Size(min = 1, max = 45)
    private String address;
    @NotNull
    private boolean administrator;
    @NotNull
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
