package com.rahulsharma.BookingInventry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookingInventryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingInventryApplication.class, args);
	}

}
