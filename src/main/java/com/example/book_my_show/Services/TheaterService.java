package com.example.book_my_show.Services;


import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Genres.SeatType;
import com.example.book_my_show.Models.TheaterEntity;
import com.example.book_my_show.Models.TheaterSeatEntity;
import com.example.book_my_show.Repositories.TheaterRepository;
import com.example.book_my_show.Repositories.TheaterSeatRepository;
import com.example.book_my_show.convertors.TheaterConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    public String addTheater(TheaterEntryDto theaterEntryDto)
    {
        TheaterEntity theaterEntity= TheaterConvertor.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList=createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);
        return "theater added successfully";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity) {

        int noClassicSeats= theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats=theaterEntryDto.getPremiumSeatsCount();

        List<TheaterSeatEntity> theaterSeatEntityList=new ArrayList<>();


        //created the classic Seats
        for(int count=1;count<=noClassicSeats;count++)
        {
            //we need to make a new theaterseatentity

            TheaterSeatEntity theaterSeatEntity=TheaterSeatEntity.builder().
                    seatType(SeatType.CLASSIC).seatNo(count+"C").theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //premium seats;
        for(int count=1;count<=noClassicSeats;count++)
        {
            //we need to make a new theaterseatentity

            TheaterSeatEntity theaterSeatEntity=TheaterSeatEntity.builder().
                    seatType(SeatType.PREMIUM).seatNo(count+"P").theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;

    }
}
