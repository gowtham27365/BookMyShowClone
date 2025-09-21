package com.example.bookmyshow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Theatre extends BaseModel {
    private String name;

    @ManyToOne
    private Region region; // 1 : 1 && M : 1 => M : 1
  
    @OneToMany
    private List<Screen> screens; //1 : M && 1 : 1 = > 1 : M
    
}
