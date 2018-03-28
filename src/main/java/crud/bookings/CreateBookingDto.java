package crud.bookings;


public class CreateBookingDto {

    private Long userId;
    private Long bookId;

    public CreateBookingDto(){}

    public CreateBookingDto(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}


