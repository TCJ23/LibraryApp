package crud.bookings;

public class BookingLimitReach extends RuntimeException{

    private static String MESSAGE_PATTERN = "Limit for user %s was exited while adding book %s";

    public final Long userId;
    public final Long bookId;

    public BookingLimitReach(Long userId, Long bookId) {
        super(String.format(MESSAGE_PATTERN, userId, bookId));
        this.userId = userId;
        this.bookId = bookId;
    }
}
