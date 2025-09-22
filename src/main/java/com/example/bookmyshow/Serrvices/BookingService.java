package com.example.bookmyshow.Serrvices;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookmyshow.Models.Booking;



public class BookingService {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> seatIds) {
        // 1. Get the user by userId
        // 2. Get the show by showId
        // --------------Taking Lock----------------
        // 3. Get ShowSeaats by seatIds
        // 4. Check if the seats are available
        // 5.If Not available, throw exception
        //  6. If available, mark them as Locked
        // 7.save updatted showSeats to DB
        //----------------END Lock----------------
        // 8.Return
        // But Taking Lock and Releasing Lock at speific point of time is very defficult as it requires kowledge in Spring.
        // For this Reason,, we will take a lock on whole steps 1 to 8.
        // This will reduce the performance of the application.
        return null;
    }
}
