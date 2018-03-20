package crud.book;

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

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

    public Book updateBook(UpdateBookDto updateBookDto) {
        Objects.requireNonNull(updateBookDto);
        Book book = bookRepository.findOne(updateBookDto.getId());
        book.setName(updateBookDto.getName());
        return bookRepository.save(book);
    }

    public Book createBook(CreateBook createBook) {
        Objects.requireNonNull(createBook);
        Book book = new Book(createBook.getName(), createBook.getIsbn());
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Book findBook(Long id) {
        Objects.requireNonNull(id);
        return bookRepository.findOne(id);
    }


}
