package com.example.productservice.dto;

public record ProductRequest(
        String name,
        double price,
        int stock
) {
}
