package crud.book.web;

import crud.book.Book;
import crud.book.BookService;
import crud.book.CreateBook;
import crud.book.UpdateBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    Book getBook(@PathVariable Long id){
        return bookService.findBook(id);
    }

    @GetMapping
    List<Book> getBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping
    ResponseEntity createBook(@RequestBody CreateBook book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping
    ResponseEntity update(@RequestBody UpdateBookDto updateBookDto){
        bookService.updateBook(updateBookDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        bookService.deleteBook(id);
    }







}
