package com.example.docpat_Backend.service;

import com.example.docpat_Backend.request.AuthenticationRequest;
import com.example.docpat_Backend.resposne.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}

