package com.example.bookmyshow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.Models.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
   @Override
   default List<ShowSeat> findAllById(Iterable<Long> ids) {
       // TODO Auto-generated method stub
       throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
   }
    ShowSeat save(ShowSeat seat);// Adds a new row, if object does not have Id, otherwise it updates
}
