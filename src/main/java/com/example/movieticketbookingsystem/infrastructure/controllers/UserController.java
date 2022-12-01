package com.example.movieticketbookingsystem.infrastructure.controllers;

import com.example.movieticketbookingsystem.domain.entities.User;
import com.example.movieticketbookingsystem.usercase.payload.request.RegistrationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody RegistrationDTO registrationDTO){
        User user = User.builder()
                .id(1L)
                .firstName(registrationDTO.getFirstName())
                .lastName(registrationDTO.getLastName())
                .password(registrationDTO.getPassword())
                .createdAt(LocalDateTime.now())
                .build();
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("show-users")
    public ResponseEntity<User> getUserById(){
        return new ResponseEntity<>(new User(1L, "Ogberawhe", "1234", "sam@gmail.com","08071387980","paslid9734", LocalDateTime.now()), HttpStatus.OK);
    }

}
