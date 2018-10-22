package com.epam.lab7;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bookName;
    private String author;
    private String genre;
    private int id;

    public Book() {
    }

    public Book(String bookName, String genre, String author, int id) {
        this.bookName = bookName;
        this.genre = genre;
        this.author = author;
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }
    @XmlElement
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }
    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    @XmlElement
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "-:-" + bookName + "-:-" + author + "-:-" + genre;
    }
}