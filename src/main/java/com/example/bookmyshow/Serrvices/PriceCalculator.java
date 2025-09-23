package com.example.bookmyshow.Serrvices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatType;
import com.example.bookmyshow.Repositories.ShowSeatTypeRepository;

@Service
public class PriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> seats, Show show) {
        int amount = 0;
        // Get all the ShowSeatType for this show
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for (ShowSeat showSeat : seats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatTypes)) {
                    amount += showSeatType.getPrice();
                }
            }
        }
        return amount;
    }
}
