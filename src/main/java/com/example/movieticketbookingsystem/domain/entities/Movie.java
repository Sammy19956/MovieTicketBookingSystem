package com.example.movieticketbookingsystem.domain.entities;

import com.example.movieticketbookingsystem.domain.entities.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie {

    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    private String director;
    private String boxOffice;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime releaseDate;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime uploadedAt;

}
