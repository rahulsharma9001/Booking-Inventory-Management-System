package com.rahulsharma.BookingInventry.repository;

import com.rahulsharma.BookingInventry.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);

}
