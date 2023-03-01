package com.example.book_my_show.Contrlollers;


import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TicketController {


    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicker(@RequestBody TicketEntryDto ticketEntryDto)
    {
        try{
            String result=ticketService.addTicket(ticketEntryDto);
            return  result;

        }catch (Exception e)
        {
            return "not booked something is wrong";

        }
    }
}
