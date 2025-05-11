package com.cloudkitchen.customer_ms.controller;

import com.cloudkitchen.customer_ms.dto.LoginRequest;
import com.cloudkitchen.customer_ms.dto.Signuprequest;
import com.cloudkitchen.customer_ms.model.Customer;
import com.cloudkitchen.customer_ms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody Signuprequest request) {
        if (customerRepo.findByUsername(request.username) != null) {
            return "Username already exists!";
        }

        Customer customer = new Customer();
        customer.setUsername(request.username);
        customer.setPassword(passwordEncoder.encode(request.password));  // Encrypt here
        customer.setName(request.name);
        customer.setPhone(request.phone);
        customer.setAddress(request.address);
        customerRepo.save(customer);

        return "User registered successfully.";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Customer customer = customerRepo.findByUsername(request.username);
        if (customer != null && passwordEncoder.matches(request.password, customer.getPassword())) {
            return "Login successful.";
        }
        return "Invalid username or password.";
    }


}


