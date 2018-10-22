package com.epam.lab7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static List<Book> books;
    private static final Logger LOGGER = LogManager.getLogger(BookDAO.class);
    {
        books = new ArrayList<>();
        books.add(new Book("White fang", "novel", "Jack London", 1));
        books.add(new Book("The Hunger Games", "fantastic", " Suzanne Collins", 2));
        books.add(new Book("Harry Potter and the Order of the Phoenix", "novel", "J.K. Rowling", 3));
        books.add(new Book("To Kill a Mockingbird", "novel", "Harper Lee", 4));
        books.add(new Book("Pride and Prejudice", "novel", "Jane Austen", 5));
        books.add(new Book("Twilight", "novel", "Stephenie Meyer", 6));
        books.add(new Book("The Book Thief", "novel", "MarkusZusak", 7));
    }
    public List getAllBooks() {
        LOGGER.info("Returned list of books");
        return books;
    }

    public Book getBook(String str) {
        LOGGER.info("Get book");
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(str)) {
                books.remove(book);
                LOGGER.info("Book was get");
                return book;
            }
        }
        return null;
    }

    public Book returnBook(Book book) {
        LOGGER.info("Adding book");
        books.add(book);
        return book;
    }

    public Book excangeBook(String bookName, Book newBook) {
        LOGGER.info("Exchanging book");
        for(Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                books.remove(book);
                books.add(newBook);
                return newBook;
            }
        }
        return null;
    }
    public List<Book> getFiveBooksTheSameAuthor(String author) {
        List<Book> authorBook = new ArrayList<>();
        for (int i = 0; i < books.size() - 1; i++) {
            if (books.get(i).getAuthor().equalsIgnoreCase(author)) {
                if (authorBook.size() < 5)
                authorBook.add(books.get(i));
                else break;
            }
        }
        return authorBook;
    }
}
