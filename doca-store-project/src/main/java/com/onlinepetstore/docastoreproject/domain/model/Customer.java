package com.onlinepetstore.docastoreproject.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private Date bornDate;
    private String phoneNumber;
    private String emailAddress;
    private String Address;
    private String password;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
}
