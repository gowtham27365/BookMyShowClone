package com.example.bookmyshow.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.Models.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
    Optional<Show> findById(Long showId);
}
