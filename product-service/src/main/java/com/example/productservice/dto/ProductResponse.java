package com.example.productservice.dto;

public record ProductResponse (
        Long id,
        String name,
        double price,
        int stock
){
}
