package com.example.book_my_show.Contrlollers;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserEntryDto userEntryDto){

        return "";

    }
}
