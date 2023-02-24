package org.userwebapp.service;

import org.userwebapp.model.Book;

import java.util.List;

public interface BooksDAO {
    public int save(Book book);

    public int update(Book book);

    public void delete(int id);

    public Book getBook(int isbn);

    public List<Book> getBookList();
}
