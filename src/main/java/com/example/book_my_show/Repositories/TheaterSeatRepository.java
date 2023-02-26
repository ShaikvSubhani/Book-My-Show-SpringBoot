package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer> {


}
