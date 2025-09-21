package com.example.bookmyshow.Models;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Show extends BaseModel{
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private Date endTime;
    private List<Feature> features;


}
