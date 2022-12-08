package com.example.movieticketbookingsystem.infrastructure.controllers;

import com.example.movieticketbookingsystem.domain.entities.Enums.UserRole;
import com.example.movieticketbookingsystem.domain.entities.User;
import com.example.movieticketbookingsystem.usercase.payload.request.RegistrationDTO;
import com.example.movieticketbookingsystem.usercase.payload.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody RegistrationDTO registrationDTO){
        User user = User.builder()
                .firstName(registrationDTO.getFirstName())
                .lastName(registrationDTO.getLastName())
                .phoneNumber(registrationDTO.getPhoneNumber())
                .email(registrationDTO.getEmail())
                .password(registrationDTO.getPassword())
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("show-users")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<User> getUserById(){
        return null;
    }
}
