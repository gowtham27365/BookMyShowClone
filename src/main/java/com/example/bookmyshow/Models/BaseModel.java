package com.example.bookmyshow.Models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Using Lombok to reduce boilerplate code for getters and setters
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
 

}
