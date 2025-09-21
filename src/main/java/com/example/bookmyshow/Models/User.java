package com.example.bookmyshow.Models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String email;
    private List<Booking> bookings;
    

}
