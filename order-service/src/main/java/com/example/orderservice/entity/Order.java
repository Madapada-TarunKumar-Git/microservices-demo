package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private double price;
    private String status;

    public Order(Long userId, Long productId, double price, String status){
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.status = status;
    }
}
