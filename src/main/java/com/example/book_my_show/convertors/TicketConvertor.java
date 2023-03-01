package com.example.book_my_show.convertors;

import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.Models.ShowEntity;
import com.example.book_my_show.Models.TicketEntity;
import com.example.book_my_show.Models.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class TicketConvertor {

    public static TicketEntity convertDtoToEntity(TicketEntryDto ticketEntryDto)
    {
//        private String movieName;
//
//        private LocalDate showDate;
//
//        private LocalTime showTime;
//
//        private int totalAmount;
//
//        private String ticketId = UUID.randomUUID().toString();
//
//        private String theaterName;
//
//        private String bookedSeats;
//
//
//        @JoinColumn
//        @ManyToOne
//        private UserEntity userEntity;
//
//
//        //Ticket is child wrt to showEntity
//        @ManyToOne
//        @JoinColumn
//        private ShowEntity showEntity;

        TicketEntity ticketEntity=new TicketEntity();
        return ticketEntity;
    }
}
