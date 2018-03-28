package crud.bookings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BookingServiceTest {


    BookingService bookingService;
    BookingRepository bookingRepository;

    @Before
    public void setup() {
        bookingRepository = Mockito.mock(BookingRepository.class);
        bookingService = new BookingService(bookingRepository);
    }

    @Test
    public void createBooking() {
        try {
            bookingService.createBooking(null);
            Assert.fail("Should throw nullpointer exception");
        } catch (NullPointerException e) {
            //success
        }
    }

    @Test
    public void given3Books_shouldThrowBookingLimitReachException() {
        //given
        Long userId = 1L;
        Long bookId = 1L;
        long currentBookCount = 3L;
        Mockito.when(bookingRepository.countByUserId(userId)).thenReturn(currentBookCount);
        CreateBookingDto createBookingDto = new CreateBookingDto(userId, bookId);
        //when
        try {
            bookingService.createBooking(createBookingDto);
            Assert.fail("should throw BookingLimitReach");
        } catch (BookingLimitReach e) {
            //then
            Assert.assertSame(bookId, e.bookId);
            Assert.assertSame(userId, e.userId);
        }
    }

    @Test
    public void given2Books_shouldSaveBookToRepository(){
        //given
        Long expectedUserId = 1L;
        Long expectedBookId = 1L;
        long currentBKcount = 2;
        //when
        Mockito.when(bookingRepository.countByUserId(expectedUserId)).thenReturn(currentBKcount);
        CreateBookingDto createBookingDtoTest = new CreateBookingDto(expectedUserId, expectedBookId);
        Booking result = bookingService.createBooking(createBookingDtoTest);
        //then
        Assert.assertSame(expectedUserId, result.getUserId());
        Assert.assertSame(expectedBookId, result.getBookId());
    }
}