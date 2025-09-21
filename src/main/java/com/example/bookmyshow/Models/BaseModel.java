package com.example.bookmyshow.Models;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Using Lombok to reduce boilerplate code for getters and setters
@MappedSuperclass
//Mapped Superclass to indicate that this class is a base class for JPA entities
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
 

}
