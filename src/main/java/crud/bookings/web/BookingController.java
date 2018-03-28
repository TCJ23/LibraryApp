package crud.bookings.web;

import crud.bookings.BookingLimitReach;
import crud.bookings.BookingService;
import crud.bookings.CreateBookingDto;
import crud.bookings.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{id}")
    Booking getBooking(@PathVariable Long id) {return bookingService.findBooking(id);}

    @GetMapping
    Iterable<Booking> getBookings() {
        return bookingService.findAllBookings();
    }

    @PostMapping
    ResponseEntity creatBooking(@RequestBody CreateBookingDto createBookingDto) {
        return ResponseEntity.ok(bookingService.createBooking(createBookingDto));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @ExceptionHandler(BookingLimitReach.class)
    ResponseEntity handleException(BookingLimitReach e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
