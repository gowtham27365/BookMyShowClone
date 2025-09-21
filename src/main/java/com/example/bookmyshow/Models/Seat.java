package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private String seatNumber;
    private SeatType seatType;
    private int row;
    private int col;
    

}
