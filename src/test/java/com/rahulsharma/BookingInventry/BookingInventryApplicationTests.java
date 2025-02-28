package com.rahulsharma.BookingInventry;

import com.rahulsharma.BookingInventry.entity.Book;
import com.rahulsharma.BookingInventry.exception.InsufficientStockException;
import com.rahulsharma.BookingInventry.repository.BookRepository;
import com.rahulsharma.BookingInventry.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookingInventryApplicationTests {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllBooks() {
		when(bookRepository.findAll()).thenReturn(List.of(new Book()));
		assertEquals(1, bookService.getAllBooks().size());
	}



	@Test
	void testPurchaseBook_OutOfStock() {
		Book book = new Book();
		book.setId(1L);
		book.setQuantityInStock(0);

		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

		assertThrows(InsufficientStockException.class, () -> bookService.purchaseBook(1L, 1));
	}

	@Test
	void testDeleteBook() {
		doNothing().when(bookRepository).deleteById(1L);
		bookService.deleteBook(1L);
		verify(bookRepository, times(1)).deleteById(1L);
	}

	@Test
	void testSearchBooksByTitle() {
		when(bookRepository.findByTitleContainingIgnoreCase("Test"))
				.thenReturn(List.of(new Book()));
		assertEquals(1, bookService.searchBooksByTitle("Test").size());
	}

	@Test
	void testPurchaseBook_InvalidQuantity() {
		Book book = new Book();
		book.setId(1L);
		book.setQuantityInStock(0);

		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

		assertThrows(InsufficientStockException.class, () -> bookService.purchaseBook(1L, 1));
	}

}
