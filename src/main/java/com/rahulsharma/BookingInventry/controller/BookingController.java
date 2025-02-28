package com.rahulsharma.BookingInventry.controller;

import com.rahulsharma.BookingInventry.entity.Book;
import com.rahulsharma.BookingInventry.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookingController {
    private static final Logger log = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    public BookService service;

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        log.info("Received request to get all books");
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        log.info("Received request to get book by ID: {}", id);
        return service.getBookById(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        log.info("Received request to search books by title: {}", title);
        return service.searchBooksByTitle(title);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        log.info("Received request to add book: {}", book.getTitle());
        service.saveBook(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        log.info("Received request to update the book with ID: {}", id);
        book.setId(id);
        return service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        log.info("Received request to delete book with ID: {}", id);
        service.deleteBook(id);
        log.info("Book with ID " + id + " deleted Successfully");
    }

    @PostMapping("/{id}/purchase")
    public Book purchaseBook(@PathVariable Long id, @RequestParam int quantity) {
        log.info("Received request to purchase book with ID: {} and quantity: {}", id, quantity);
        return service.purchaseBook(id, quantity);
    }
}
