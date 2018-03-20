package crud.book;

public class CreateBook {

    private String name;
    private String isbn;

    public CreateBook(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    CreateBook() {
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
