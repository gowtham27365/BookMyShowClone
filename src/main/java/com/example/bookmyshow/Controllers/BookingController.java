package com.example.bookmyshow.Controllers;

import com.example.bookmyshow.Dtos.BookMovieRequestDto;
import com.example.bookmyshow.Dtos.BookMovieResponseDto;
import com.example.bookmyshow.Dtos.ResponseStatus;
import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Serrvices.BookingService;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto) {
        // Validate the request
        // Check seat availability
        // Process payment
        // Confirm booking
        // Return response
        BookMovieResponseDto response = new BookMovieResponseDto();
        Booking booking;
        try{
            booking = bookingService.bookMovie(
                bookMovieRequestDto.getUserId(),
                 bookMovieRequestDto.getShowId(),
                 bookMovieRequestDto.getSeatIds());
                 response.setAmount(booking.getAmount());
                 response.setResponseStatus(ResponseStatus.SUCCESS);
                 response.setUserId(booking.getUser().getId());
        }
        catch(Exception e){
            response.setResponseStatus(ResponseStatus.FAILED);
        }

        return response;
    }
}
