package com.example.book_my_show.Services;


import com.example.book_my_show.Models.UserEntity;
import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Repositories.UserRepository;
import com.example.book_my_show.convertors.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    //builder annotations we use to set the properties at a time
    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{

        UserEntity userEntity= UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);

        return "user added successfully";
    }





}
