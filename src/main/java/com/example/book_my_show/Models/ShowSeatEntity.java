package com.example.book_my_show.Models;


import com.example.book_my_show.Genres.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="showseats")
@Data
@NoArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private boolean isBooked;

    private int price;

    @Enumerated(value=EnumType.STRING)
    private SeatType seatType;

    private Date bookedAt;
}
