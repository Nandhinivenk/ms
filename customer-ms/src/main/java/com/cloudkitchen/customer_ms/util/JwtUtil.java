package com.cloudkitchen.customer_ms.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "your_jwt_secret_key"; // Use env var or key vault in prod
    private static final long EXPIRATION = 86400000; // 1 day

    public static String generateToken(Long customerId, String username) {
        return Jwts.builder()
                .claim("customerId", customerId)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
