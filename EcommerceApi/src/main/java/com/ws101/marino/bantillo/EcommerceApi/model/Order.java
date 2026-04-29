package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Represents a customer order.
 * One order can have many order items.
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * One order has many order items.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
}