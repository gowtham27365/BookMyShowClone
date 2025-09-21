package com.example.bookmyshow.Models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    private Region region;
    private List<Screen> screens;
    
}
