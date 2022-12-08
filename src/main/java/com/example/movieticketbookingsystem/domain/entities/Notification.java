package com.example.movieticketbookingsystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Notification extends AbstractEntity{
    private String title;
    private String message;
    private String notificationBody;

    @ManyToOne
    @JsonBackReference(value = "user")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
