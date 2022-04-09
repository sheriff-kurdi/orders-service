package com.kurdi.ordersservice.repositories;

import com.kurdi.ordersservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
