package com.example.book_my_show.Contrlollers;


import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/add")
    public  String addUser(@RequestBody UserEntryDto userEntryDto)
    {
        return "";
    }

}
