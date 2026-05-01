package com.example.orderservice.service;

import com.example.orderservice.client.ProductClient;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.ProductDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repo.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

    @Override
    public OrderResponse createOrder(Long userId, Long productId) {
        userClient.getUser(userId);
        ProductDto product = fetchProduct(productId);
        Order order = new Order(
                userId,
                productId,
                product.price(),
                product.price() == 0.0 ? "CREATED_WITH_FALLBACK" : "CREATED"
        );
        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved);
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "productFallback")
    @Retry(name = "productService")
    public ProductDto fetchProduct(Long productId) {
        return productClient.getProduct(productId);
    }

    //Fallback method
    public ProductDto productFallback(Long productId, Throwable ex) {
        return new ProductDto(
                productId,
                "DEFAULT_PRODUCT",
                0.0
        );
    }
}
