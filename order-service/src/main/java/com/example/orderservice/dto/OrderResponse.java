package com.example.orderservice.dto;

public record OrderResponse(
        Long orderId,
        Long userId,
        Long productId,
        double price,
        String status
) {
}
