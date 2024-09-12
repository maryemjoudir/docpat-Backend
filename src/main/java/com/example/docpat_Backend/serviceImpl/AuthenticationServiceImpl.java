package com.example.docpat_Backend.serviceImpl;

import com.example.docpat_Backend.dto.UserDTO;
import com.example.docpat_Backend.entity.User;
import com.example.docpat_Backend.repository.UserRepository;
import com.example.docpat_Backend.request.AuthenticationRequest;
import com.example.docpat_Backend.resposne.AuthenticationResponse;
import com.example.docpat_Backend.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    public User createUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        return userRepository.save(user);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var accessToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .user(new UserDTO(user.getId(), user.getEmail(), null))
                .build();
    }

}

