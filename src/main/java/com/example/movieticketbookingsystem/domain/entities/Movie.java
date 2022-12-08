package com.example.movieticketbookingsystem.domain.entities;

import com.example.movieticketbookingsystem.domain.entities.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie extends AbstractEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    private String director;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private String duration;
    private String releaseDate;
    private String rating;
    private String trailerUrl;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
