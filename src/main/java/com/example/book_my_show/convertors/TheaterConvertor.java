package com.example.book_my_show.convertors;

import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Models.TheaterEntity;

public class TheaterConvertor {

//    private String name;
//
//    private String address;
//
//    private int classicSeatsCount;
//
//    private int premiumSeatsCount;

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto)
    {
        TheaterEntity theaterEntity=TheaterEntity.builder().name(theaterEntryDto.getName())
                .location(theaterEntryDto.getAddress()).build();

        return theaterEntity;
    }
}
