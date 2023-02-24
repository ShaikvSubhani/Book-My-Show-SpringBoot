package com.example.book_my_show.Services;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Models.UserEntity;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    public void addUser(UserEntryDto userEntryDto)
    {
        //here we need to convert and save.
        //old method create a object and set attributes
        //but now will use builder annotation

        UserEntity userEntity=UserEntity.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).
                address(userEntryDto.getAddress()).email(userEntryDto.getEmail()).mobNo(userEntryDto.getMobNo()).build();

        //this is to set all the attributes in one go
        userRepository.save(userEntity);
    }
}
