package com.example.bookmyshow.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    @ManyToMany
    private List<ShowSeat> showSeats; // B - > S :- 1 : M && M : 1 =>> M : M

    @ManyToOne
    private User user;  // B -> U :- 1 : 1 && M : 1  => M : 1
    private Date bookedAt;
    private int amount;
    @ManyToOne
    private  Show show; // B - > s : - 1 : 1 && M : 1 = > M : 1

    @OneToMany
    private List<Payment> payments; // B - > P : - 1 : M && 1 : 1 =>> M : 1

}
