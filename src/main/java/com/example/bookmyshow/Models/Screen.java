package com.example.bookmyshow.Models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats; // 1 : M && 1 : 1 => 1 : M
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection   //mapping table  screen_feature
    private List<Feature> features;


}
