package com.example.docpat_Backend.service;


import com.example.docpat_Backend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;

public interface JwtService {

    String generateToken(User user);
    String extractUsername(String token);
    boolean isValid(String token, UserDetails user);

}
