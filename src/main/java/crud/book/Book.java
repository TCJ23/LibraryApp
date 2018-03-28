package crud.book;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String isbn;


    private Book(){

    }

    public Book(String name, String isbn) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(isbn);
        this.name = name;
        this.isbn = isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
