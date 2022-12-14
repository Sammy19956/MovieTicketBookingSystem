package com.example.movieticketbookingsystem.domain.entities.Enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public enum UserRole {
    ADMIN,
    USER;

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){

        Set<SimpleGrantedAuthority> set = new HashSet<>();
        set.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return set;
    }
}
