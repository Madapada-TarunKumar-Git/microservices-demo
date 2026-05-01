package com.example.orderservice.dto;

public record ProductDto(
        Long id,
        String name,
        double price
) {
}
