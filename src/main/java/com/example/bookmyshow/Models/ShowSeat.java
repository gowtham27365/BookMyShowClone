package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show; // 1 : 1  && M : 1 = > M : 1
    @ManyToOne
    private Seat seat; // 1 : 1 && M : 1 => M : 1
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;

}
