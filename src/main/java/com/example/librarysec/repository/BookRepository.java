package com.example.librarysec.repository;

import com.example.librarysec.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();
    void save(Book book);
    void deleteByIndex(int index);

}
