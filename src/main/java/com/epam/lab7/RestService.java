package com.epam.lab7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestService {

    // @Autowired
    private BookDAO bookDAO = new BookDAO();

    @GetMapping("/books")
    public List getBooks() {
        return bookDAO.getAllBooks();
    }

    @DeleteMapping("/books/{bookName}")
    ResponseEntity getBook(@PathVariable("bookName") String bookName) {
        Book book = bookDAO.getBook(bookName);
        if (book == null) {
            return new ResponseEntity("No books found for name " + bookName, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    ResponseEntity returnBook(@RequestBody Book book) {
        bookDAO.returnBook(book);
        return new ResponseEntity(book.getBookName(), HttpStatus.OK);
    }

    @PutMapping("/books/{bookName}")
    public ResponseEntity excangeBook(@PathVariable String bookName, @RequestBody Book newBook) {
        newBook = bookDAO.excangeBook(bookName, newBook);
        if (newBook == null) {
            return new ResponseEntity("No book found for title " + bookName, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(newBook, HttpStatus.OK);
    }

    @GetMapping("/books/{author}")
    public ResponseEntity getFiveBooks(@PathVariable String author) {
        List<Book> authorBooks = bookDAO.getFiveBooksTheSameAuthor(author);
        if (authorBooks.isEmpty()) {
            return new ResponseEntity("There no books of the author " + author, HttpStatus.NOT_FOUND);
        } else if (authorBooks.size() < 5) {
            return new ResponseEntity("Less than 5 books", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(authorBooks, HttpStatus.OK);
    }
}
