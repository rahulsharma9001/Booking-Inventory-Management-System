package com.rahulsharma.BookingInventry.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.rahulsharma.BookingInventry.repository")
@EntityScan(basePackages = "com.rahulsharma.BookingInventry.entity")
public class JpaConfig {
}
