package com.kurdi.ordersservice.repositories;

import com.kurdi.ordersservice.entities.OrderItem;
import com.kurdi.ordersservice.entities.compositeKeys.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, OrderItemId> {
}
