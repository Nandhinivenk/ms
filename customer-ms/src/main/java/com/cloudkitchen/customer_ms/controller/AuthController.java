package com.cloudkitchen.customer_ms.controller;

import com.cloudkitchen.customer_ms.dto.LoginRequest;
import com.cloudkitchen.customer_ms.dto.Signuprequest;
import com.cloudkitchen.customer_ms.model.Customer;
import com.cloudkitchen.customer_ms.repository.CustomerRepository;
import com.cloudkitchen.customer_ms.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        customer.setPassword(passwordEncoder.encode(request.password));
        customer.setName(request.name);
        customer.setPhone(request.phone);
        customer.setAddress(request.address);

        customerRepo.save(customer);
        return "User registered successfully.";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Customer customer = customerRepo.findByUsername(request.username);

        if (customer != null && passwordEncoder.matches(request.password, customer.getPassword())) {
            String token = JwtUtil.generateToken(customer.getId(), customer.getUsername());

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("customerId", customer.getId());
            response.put("name", customer.getName());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
