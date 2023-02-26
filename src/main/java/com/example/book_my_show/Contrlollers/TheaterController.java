package com.example.book_my_show.Contrlollers;


import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto)
    {

        try{

            String response

        }catch (Exception e)
        {

        }
    }
}
