package com.epam.lab7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestClient {
    RestService restService = new RestService();
    HttpStatus status;
    public void getBookByTitle(String author) {
        restService.getBook(author);

    }

    public HttpStatus returnBook(Book book) {
         status = restService.returnBook(book).getStatusCode();
        return status;
    }

    public HttpStatus getBook(String title) {
        status = restService.getBook(title).getStatusCode();
        return status;
    }

    public HttpStatus excangeBook(String title, Book book) {
        status = restService.excangeBook(title, book).getStatusCode();
        return status;
    }

}
