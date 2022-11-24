package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
// @Table(name = "employee")
public class Employee {

    // @Column(value = "employeeid")
    private int employeeId;
    private String firstName;
    private String lastName;
    private Date bornDate;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private boolean administrator;
    private String password;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private int employeeRegisterId;
    private int employeeUpdateId;
}
