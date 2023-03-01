package com.example.book_my_show.Services;


import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.Models.*;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TicketRepository;
import com.example.book_my_show.Repositories.UserRepository;
import com.example.book_my_show.convertors.TheaterConvertor;
import com.example.book_my_show.convertors.TicketConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TicketEntryDto ticketEntryDto) throws Exception
    {
        //1> convert entrydto to ticket entity;

        TicketEntity ticketEntity= TicketConvertor.convertDtoToEntity(ticketEntryDto);

        //validation : check if the seat are available or not?
        boolean isValidRequest=checkValidityofRequestedSeats(ticketEntryDto);
        if(isValidRequest==false)
        {
            throw new Exception("Seats are not available");
        }

        //if it comes here we assume that the requested seats are valid


        //calculate the total amount
        List<String> requestedSeats=ticketEntryDto.getRequestedSeats();
        ShowEntity showEntity=showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> showSeatEntityList=showEntity.getListOfShowSeats();

        int totalAmount=0;
        for(ShowSeatEntity showSeatEntity: showSeatEntityList)
        {
            if(requestedSeats.contains(showSeatEntity.getSeatNo()))
            {
                totalAmount+=showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }

        ticketEntity.setTotalAmount(totalAmount);

        //setting the other attributes for the ticket entity
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());

        String allotedSeats=getAllotedSeatsfromShowSeats(requestedSeats);
        ticketEntity.setBookedSeats(allotedSeats);

        //setting the foreign key attributes and other key attributes
        UserEntity userEntity=userRepository.findById(ticketEntryDto.getUserId()).get();

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);
        //save the parent

        List<TicketEntity> ticketEntityList=showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);

        showRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1=userEntity.getBookedTickets();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntityList1);

        userRepository.save(userEntity);

        return "ticket has been booked successfully";
    }
    public String getAllotedSeatsfromShowSeats(List<String> requestedSeats)
    {

        String result="";

        for(String seat : requestedSeats)
        {
            result = result + seat + ", ";
        }

        return result;
    }

    public boolean checkValidityofRequestedSeats(TicketEntryDto ticketEntryDto)
    {
        int showId= ticketEntryDto.getShowId();
        List<String> requestedSeats=ticketEntryDto.getRequestedSeats();

        ShowEntity showEntity=showRepository.findById(showId).get();
        List<ShowSeatEntity> listOfSeats=showEntity.getListOfShowSeats();

        //iterating over the listof seats for that particular show
        for(ShowSeatEntity showSeatEntity: listOfSeats)
        {
            String seatNo=showSeatEntity.getSeatNo();

            if(requestedSeats.contains(seatNo))
            {
                if(showSeatEntity.isBooked()==true)
                    return false;
            }
        }

        return true;
    }
}
