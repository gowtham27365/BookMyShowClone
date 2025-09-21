package com.example.bookmyshow.Models;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking extends BaseModel {
    private BookingStatus status;
    private List<ShowSeat> showSeats;
    private User user;
    private Date bookedAt;
    private int amount;
    private  Show show;
    private List<Payment> payments;

}
