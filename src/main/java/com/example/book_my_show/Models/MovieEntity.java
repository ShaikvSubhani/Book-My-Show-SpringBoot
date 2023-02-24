package com.example.book_my_show.Models;


import com.example.book_my_show.Genres.Genre;
import com.example.book_my_show.Genres.Language;
import jakarta.persistence.*;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import jdk.jfr.Unsigned;
import lombok.Data;

@Entity
@Table(name="movies")
@Data
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true,nullable = false)
    private String movieName;

    private double rating;

    private int duration;


    @Enumerated(value=EnumType.STRING)
    private Language language;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;




}
