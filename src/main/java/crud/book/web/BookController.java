package crud.book.web;

import crud.book.Book;
import crud.book.BookService;
import crud.book.CreateBookDto;
import crud.book.UpdateBookDto;
import crud.user.User;
import crud.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    Book getBook(@PathVariable Long id){
        return bookService.findBook(id);
    }

    @GetMapping("/rentedBooks/{id}")
    Iterable<Book> listUserBooks(@PathVariable Long id){return bookService.findAllUserBooks(userService.findUser(id));}

    @GetMapping
    Iterable<Book> getBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping
    ResponseEntity createBook(@RequestBody CreateBookDto createBookDto){
        return ResponseEntity.ok(bookService.createBook(createBookDto));
    }

    @PutMapping("/{id}")
    ResponseEntity updateBook(@PathVariable Long id, @RequestBody UpdateBookDto updateBookDto){
        bookService.updateBook(id, updateBookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
