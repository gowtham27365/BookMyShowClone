package com.example.bookmyshow.Models;

import org.springframework.jmx.export.annotation.ManagedNotification;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

   private String RefNo;
   private int amount;
   @Enumerated(EnumType.ORDINAL)
   private PaymentProvider paymentProvider; 
   @Enumerated(EnumType.ORDINAL)
   private PaymentStatus paymentStatus; 

}
