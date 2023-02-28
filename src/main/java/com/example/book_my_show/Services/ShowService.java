package com.example.book_my_show.Services;


import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Genres.SeatType;
import com.example.book_my_show.Models.*;
import com.example.book_my_show.Repositories.MovieRepository;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TheaterRepository;
import com.example.book_my_show.convertors.ShowConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {



    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String addShow(ShowEntryDto showEntryDto)
    {
        //1st we need to create a entity, that will do by convertors

        ShowEntity showEntity= ShowConvertor.convertDtoToEntity(showEntryDto);

        int movieId= showEntryDto.getMovieId();
        int theaterId=showEntryDto.getTheaterId();

        MovieEntity movieEntity=movieRepository.findById(movieId).get();

        TheaterEntity theaterEntity=theaterRepository.findById(theaterId).get();

        //setting the attributes of the foreign key
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);


        //pending attributes the listOfShowSeatEntity

        List<ShowSeatEntity> seatEntityList=createShowSeatEntity(showEntryDto,showEntity);

        showEntity.setListOfShowSeats(seatEntityList);

        //now we also need to update parent entities

        List<ShowEntity> showEntityList = movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);

        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList1= theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);


        theaterRepository.save(theaterEntity);


        return " show added successfully";
    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity)
    {
        //now the goal is to create the showseatentity
        //we need to set its attribute

        TheaterEntity theaterEntity=showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList=theaterEntity.getTheaterSeatEntityList();
        List<ShowSeatEntity> seatEntityList=new ArrayList<>();


        for(TheaterSeatEntity theaterSeatEntity:theaterSeatEntityList)
        {
            ShowSeatEntity showSeatEntity=new ShowSeatEntity();
            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
            {
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else {
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);  //parent : foreignkey for the show seat entity

            seatEntityList.add(showSeatEntity); //adding it  to the list
        }

        return seatEntityList;
    }
}
