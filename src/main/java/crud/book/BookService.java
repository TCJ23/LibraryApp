package crud.book;

import crud.bookings.Booking;
import crud.bookings.BookingService;
import crud.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookingService bookingService;

    @Autowired
    public BookService(BookRepository bookRepository, BookingService bookingService) {
        this.bookRepository = bookRepository;
        this.bookingService = bookingService;
    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

    public Book updateBook(Long id, UpdateBookDto updateBookDto) {
        Objects.requireNonNull(updateBookDto);
        Book book = bookRepository.findOne(id);
        book.setName(updateBookDto.getName());
        book.setIsbn(updateBookDto.getIsbn());
        return bookRepository.save(book);
    }

    public Book createBook(CreateBookDto createBookDto) {
        Objects.requireNonNull(createBookDto);
        Book book = new Book(createBookDto.getName(), createBookDto.getIsbn());
        return bookRepository.save(book);
    }

    public Iterable<Book> findAllBooks() { //bez parametrów zawsze wszystkie
        Iterable<Book> books = bookRepository.findAll();
        return books;
//        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
    }

    public Book findBook(Long id) {
        Objects.requireNonNull(id);
        return bookRepository.findOne(id);
    }

    public Iterable<Book> findAllUserBooks (User user){
        Iterable<Booking> bookings = bookingService.findAllBookings();
        List<Book> books = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUserId().equals(user.getId())){
                books.add(findBook(booking.getBookId()));
            }
        }
        return books;
    }
}
