package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

}
