package com.example.bookmyshow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    
    @OneToMany
    private List<Booking> bookings;// 1 : M && 1: 1 => 1 : M
    

}
