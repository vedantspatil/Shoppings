package com.distributedsystems.orderservice.repository;

import com.distributedsystems.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
