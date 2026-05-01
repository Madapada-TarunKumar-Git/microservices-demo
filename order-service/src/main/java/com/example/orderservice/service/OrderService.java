package com.example.orderservice.service;

import com.example.orderservice.dto.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(Long userId, Long productId);
}
