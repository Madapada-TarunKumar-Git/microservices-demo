package com.example.orderservice.controller;

import com.example.orderservice.client.ProductClient;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestParam Long userId,
                                                     @RequestParam Long productId) {
        OrderResponse response = orderService.createOrder(userId,productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
