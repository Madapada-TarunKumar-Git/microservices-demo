package com.example.orderservice.service;

import com.example.orderservice.client.ProductClient;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.ProductDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repo.OrderRepository;
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
        ProductDto product = productClient.getProduct(productId);
        Order order = new Order(
                userId,
                productId,
                product.price(),
                "CREATED"
        );
        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved);
    }
}
