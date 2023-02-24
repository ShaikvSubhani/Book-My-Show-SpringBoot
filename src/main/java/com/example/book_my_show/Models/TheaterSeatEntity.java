package com.example.book_my_show.Models;


import com.example.book_my_show.Genres.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Theater_seats")
@Data
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SeatType seatType;

    private String seatNo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private TheaterEntity theaterEntity;





}
