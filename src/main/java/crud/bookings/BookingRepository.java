package crud.bookings;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository <Booking, Long> {

//    List<Booking> findByUserId(Long userId);
    long countByUserId(Long userId);
//    @Query("SELECT count(*) FROM Booking where userId = ?1")
//    long countUserBooks(Long userId);
}
