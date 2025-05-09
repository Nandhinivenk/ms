package com.cloudkitchen.customer_ms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;

    private String username;  // for login
    private String password;  // encrypted
    private String role = "ROLE_USER";  // default role
}
