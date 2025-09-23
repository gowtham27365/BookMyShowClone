package com.example.bookmyshow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Models.ShowSeatType;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long>{
    List<ShowSeatType> findAllByShow(Show show);
