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
        System.out.println("GEt all");
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return service.searchBooksByTitle(title);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        service.saveBook(book);
        return book;
    }

    @PutMapping("/makeChange/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        log.info("Book with ID " + id + "deleted Successfully");
    }
}
