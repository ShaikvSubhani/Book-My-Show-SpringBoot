package com.example.book_my_show.convertors;

import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.Genres.Genre;
import com.example.book_my_show.Genres.Language;
import com.example.book_my_show.Models.MovieEntity;

public class MovieConvertor {


    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto)
    {
        MovieEntity movieEntity=MovieEntity.builder().movieName(movieEntryDto.getMovieName()).ratings(movieEntryDto.getRatings())
                .duration(movieEntryDto.getDuration()).language(movieEntryDto.getLanguage())
                .genre(movieEntryDto.getGenre()).build();

        return movieEntity;
    }
}
