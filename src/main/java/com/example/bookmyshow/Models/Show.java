package com.example.bookmyshow.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie; // 1 : 1 && M : 1 => M : 1
    @ManyToOne
    private Screen screen; // 1 : 1 && M : 1 => M : 1

    private Date startTime;
    private Date endTime;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;


}
