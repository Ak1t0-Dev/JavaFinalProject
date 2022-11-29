package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Employee {

    private int employeeId;
    @NotBlank
    @Size(max = 45)
    private String firstName;
    @NotBlank
    @Size(max = 45)
    private String lastName;
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bornDate;
    @NotBlank
    @Size(max = 20)
    private String phoneNumber;
    @NotBlank
    @Email
    @Size(max = 45)
    private String emailAddress;
    @NotBlank
    @Size(max = 45)
    private String address;
    private boolean administrator;
    @NotBlank
    @Size(max = 100)
    private String password;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private int employeeRegisterId;
    private int employeeUpdateId;
}
