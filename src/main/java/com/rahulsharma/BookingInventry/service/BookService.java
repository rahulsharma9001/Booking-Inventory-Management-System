package com.rahulsharma.BookingInventry.service;

import com.rahulsharma.BookingInventry.entity.Book;
import com.rahulsharma.BookingInventry.repository.BookRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired(required = true)
    private BookRepository repository;

    public List<Book> getAllBooks() { return repository.findAll(); }
    public Optional<Book> getBookById(Long id) { return repository.findById(id); }
    public List<Book> searchBooksByTitle(String title) { return repository.findByTitleContainingIgnoreCase(title); }
    public Book saveBook(Book book) { return repository.save(book); }
    public void deleteBook(Long id) { repository.deleteById(id); }
}
