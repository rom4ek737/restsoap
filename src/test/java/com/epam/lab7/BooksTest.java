package com.epam.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@SpringBootTest
//@AutoConfigureMockMvc
public class BooksTest {
    @Autowired
    private MockMvc mockMvc;
    // RestClient restClient;
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private RestClient restClient;
    HttpStatus status;
    static final String URL = "http://localhost:8080/books";

    @BeforeMethod
    public void init() {
        httpHeaders = new HttpHeaders();
        restTemplate = new RestTemplate();
        restClient = new RestClient();
    }

    @Test
    public void getBooksList() {
        Book[] list = restTemplate.getForObject(URL, Book[].class);
        if (list != null) {
            for (Book book : list) {
                System.out.println(book.getBookName() + " " + book.getAuthor());
            }
        }
    }

    @Test
    public void addBookByTitle() {
        Book newBook = new Book("One", "Two", "Three", 10);
        //HttpEntity<Book> request  = new HttpEntity<>(newBook);
        status = restClient.returnBook(newBook);
        Assert.assertTrue(status == HttpStatus.OK);
    }

    @Test
    public void getIncorrectBookByTitle() {
        String title = "ololo";
        status = restClient.getBook(title);
        Assert.assertTrue(status == HttpStatus.NOT_FOUND);
    }

    @Test
    public void getCorrectBookByTitle() {
        String title = "Twilight";
        status = restClient.getBook(title);
        Assert.assertTrue(status == HttpStatus.OK);
    }

    @Test
    public void excangeBook() {
        String title = "Twilight";
        Book book = new Book("Three", "Three", "Three", 33);
        status = restClient.excangeBook(title, book);
        Assert.assertTrue(status == HttpStatus.OK);
    }
    @Test
    public void getnewBooksList() {
        Book[] list = restTemplate.getForObject(URL, Book[].class);
        if (list != null) {
            for (Book book : list) {
                System.out.println(book.getBookName() + " " + book.getAuthor());
            }
        }
    }
}
