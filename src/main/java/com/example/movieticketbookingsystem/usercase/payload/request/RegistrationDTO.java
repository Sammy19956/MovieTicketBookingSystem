package com.example.movieticketbookingsystem.usercase.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistrationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
