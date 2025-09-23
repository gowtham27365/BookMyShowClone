package com.example.bookmyshow.Serrvices;

import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Models.BookingStatus;
import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatStatus;
import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repositories.BookingRepository;
import com.example.bookmyshow.Repositories.ShowRepository;
import com.example.bookmyshow.Repositories.ShowSeatRepository;
import com.example.bookmyshow.Repositories.UserRepository;

public class BookingService {
    private UserRepository UserRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculator priceCalculator;

    public BookingService(com.example.bookmyshow.Repositories.UserRepository userRepository,
            ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository,PriceCalculator priceCalculator) {
        UserRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculator = priceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> seatIds) {

        // 1. Get the user by userId
        Optional<User> userOptional = UserRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException();
        }
        User user = userOptional.get();

        // 2. Get the show by showId

        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty())
            throw new RuntimeException();

        Show bookedShow = showOptional.get();

        // --------------Taking Lock----------------
        // 3. Get ShowSeaats by seatIds

        List<ShowSeat> savedSeats = showSeatRepository.findAllById(seatIds);
        // 4. Check if the seats are available
        // 5.If Not available, throw exception
        for (ShowSeat showSeat : savedSeats) {
            if (!(showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)) ||
                    (showSeat.getStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getLockedAt().toInstant(), java.time.Instant.now())
                                    .toMinutes() < 15)) {
                throw new RuntimeException();
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        // 6. If available, mark them as Locked
        // 7.save updatted showSeats to DB
        for(ShowSeat showSeat : savedSeats){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        
        // ----------------END Lock----------------
        // Create booking Object

        Booking booking = new Booking();
        booking.setShow(bookedShow);
        booking.setUser(user);
        booking.setStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowSeats);
        booking.setBookedAt(new Date());
        
        booking.setAmount(priceCalculator.calculatePrice(savedShowSeats, bookedShow));

        // save this Booking Object to the DB

        Booking savedBooking = bookingRepository.save(booking);
        // 8.Return
        // But Taking Lock and Releasing Lock at speific point of time is very defficult
        // as it requires kowledge in Spring.
        // For this Reason,, we will take a lock on whole steps 1 to 8.
        // This will reduce the performance of the application.
        return null;
    }
}
