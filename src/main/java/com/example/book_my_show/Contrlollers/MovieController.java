package com.example.book_my_show.Contrlollers;

import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.Models.MovieEntity;
import com.example.book_my_show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping("/addmovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto)
    {

        try{
                String response=movieService.addMovie(movieEntryDto);
                return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e)
        {
            return new ResponseEntity<>("movie could not be added",HttpStatus.BAD_REQUEST);
        }
    }
}
