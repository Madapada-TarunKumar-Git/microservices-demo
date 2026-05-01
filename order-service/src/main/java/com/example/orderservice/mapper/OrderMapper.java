package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponse toResponse(Order order){
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getProductId(),
                order.getPrice(),
                order.getStatus()
        );
    }
}
