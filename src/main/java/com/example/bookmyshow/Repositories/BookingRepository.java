package com.example.bookmyshow.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.Models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{ 
    Booking save(Booking booking);
}
