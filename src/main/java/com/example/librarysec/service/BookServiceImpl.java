package com.example.librarysec.service;

import com.example.librarysec.domain.Book;
import com.example.librarysec.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @Override
    public void createBook(Book book) {
        repository.save(book);
    }

    @Override
    public void deleteBook(int index) {
        repository.deleteByIndex(index);
    }

}
