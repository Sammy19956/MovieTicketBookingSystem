package com.example.movieticketbookingsystem.domain.entities;
import com.example.movieticketbookingsystem.domain.entities.Enums.UserRole;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@DiscriminatorValue("admin")
@Entity
@Table(name="users")
public class User extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Notification> notificationList;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Movie> movieList;
}
