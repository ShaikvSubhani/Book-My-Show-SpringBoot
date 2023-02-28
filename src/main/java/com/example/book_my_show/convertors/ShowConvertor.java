package com.example.book_my_show.convertors;

import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Models.ShowEntity;

public class ShowConvertor {

    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto)
    {
//        private int movieId;
//
//        private int theaterId;
//
//        private int classicSeatPrice;
//
//        private int premiumSeatPrice;

        ShowEntity showEntity=ShowEntity.builder().showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime()).showType(showEntryDto.getShowType())
                .build();

        return showEntity;
    }
}
