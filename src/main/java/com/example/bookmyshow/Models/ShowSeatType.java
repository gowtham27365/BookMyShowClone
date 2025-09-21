package com.example.bookmyshow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show; // 1 : 1 && M : 1 =>M : 1
    @ManyToOne
    private SeatType seatType; // 1 : 1 && M : 1 => M : 1
    private int price;

}
