package com.example.bookmyshow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
   @OneToMany
    private List<Theatre> theatres; // 1 : M&& 1 : 1 
    
   
}
