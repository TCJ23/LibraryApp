package crud.bookings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookingService {

    private static final long USER_BOOK_LIMIT = 3;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void deleteBooking(Long id) {
        bookingRepository.delete(id);
    }

    public Booking createBooking(CreateBookingDto createBookingDto) {
        Objects.requireNonNull(createBookingDto);
        long currentUserBookCount = bookingRepository.countByUserId(createBookingDto.getUserId());
        if(currentUserBookCount >= USER_BOOK_LIMIT){
            throw new BookingLimitReach(createBookingDto.getUserId(), createBookingDto.getBookId());
        }
        Booking booking = new Booking(createBookingDto.getUserId(), createBookingDto.getBookId());
        bookingRepository.save(booking);
        return booking;
    }

    public Iterable<Booking> findAllBookings() {
        Iterable<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    public Booking findBooking(Long id) {
        Objects.requireNonNull(id);
        return bookingRepository.findOne(id);
    }
}

