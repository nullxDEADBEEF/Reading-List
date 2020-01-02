package com.nullxdeadbeef.readinglist.model;

public class Book {
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    public Book() {}

    public Book( String reader, String isbn, String title, String author, String desc ) {
        this.reader = reader;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = desc;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
