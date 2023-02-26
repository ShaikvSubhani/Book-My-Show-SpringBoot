package com.example.book_my_show.convertors;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Models.UserEntity;

public class UserConvertor {


    //static is kept to avoid calling it via object
    public static  UserEntity convertDtoToEntity(UserEntryDto userEntryDto)
    {

        UserEntity userEntity= UserEntity.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress()).mobNo(userEntryDto.getMobNo()).build();

        return userEntity;
    }
}
