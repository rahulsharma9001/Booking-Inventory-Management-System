package com.rahulsharma.BookingInventry.service;

import com.rahulsharma.BookingInventry.entity.Book;
import com.rahulsharma.BookingInventry.exception.InsufficientStockException;
import com.rahulsharma.BookingInventry.repository.BookRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired(required = true)
    private BookRepository repository;

    @Cacheable(value = "books")
    public List<Book> getAllBooks() {
        System.out.println("Fetching all books from DB.......");
        return repository.findAll();
    }

    @Cacheable(value = "books" , key = "#id")
    public Optional<Book> getBookById(Long id) {
        System.out.println("Fetching book with ID: " + id + " from DB..............................");
        return repository.findById(id);
    }

    @Cacheable(value = "books", key = "#title")
    public List<Book> searchBooksByTitle(String title) {
        System.out.println("Searching books by title: " + title + " in DB........");
        return repository.findByTitleContainingIgnoreCase(title);
    }

    @CacheEvict(value = "books")
    public Book saveBook(Book book) {
        System.out.println("Saving new Book entry into the Cache: " + book.getTitle());
        return repository.save(book);
    }

    @CacheEvict(value = "books", key = "#id")
    public void deleteBook(Long id) {
        System.out.println("Deleting book from Cache with ID: " + id);
        repository.deleteById(id);
    }

    @CacheEvict(value = "books", key = "#id")
    public Book purchaseBook(Long id, int quantity) {


        // Check if stock is zero.
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getQuantityInStock() == 0) {
            throw new InsufficientStockException("Out of Stock! Purchase Rejected.");
        }
        // Check if Stock is less than the quantity.
        if (book.getQuantityInStock() < quantity) {
            throw new InsufficientStockException("Insufficient stock available");
        }
        // Updating quantity.
        book.setQuantityInStock(book.getQuantityInStock() - quantity);
        return repository.save(book);
    }
}
