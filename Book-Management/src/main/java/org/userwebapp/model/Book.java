package org.userwebapp.model;

public class Book {
    private int ISBN=0;
    private String name, author, publisher;

    public Book(){}

    public Book(int ISBN, String name, String author, String publisher) {
        this(name,author,publisher);
        this.ISBN = ISBN;
    }


    public Book(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }


    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

