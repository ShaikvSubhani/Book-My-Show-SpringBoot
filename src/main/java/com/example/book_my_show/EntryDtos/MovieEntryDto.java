package com.example.book_my_show.EntryDtos;


import com.example.book_my_show.Genres.Genre;
import com.example.book_my_show.Genres.Language;
import com.example.book_my_show.Models.ShowEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieEntryDto {

    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;

}
