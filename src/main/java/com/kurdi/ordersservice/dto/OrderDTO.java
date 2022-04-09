package com.kurdi.ordersservice.dto;

import com.kurdi.ordersservice.entities.Order;
import com.kurdi.ordersservice.entities.OrderItem;
import com.kurdi.ordersservice.entities.compositeKeys.OrderItemId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {
    String address;
    String phone;
    List<OrderItemDTO> orderItemDTOS;

    public Order toOrder(Integer identity)
    {
        List<OrderItem>  orderItems = orderItemDTOS.stream().map(orderItemDTO -> OrderItem.builder()
                .id(OrderItemId.builder().identity(identity).SKU(orderItemDTO.SKU).build())
                .quantity(orderItemDTO.quantity)
                .price(orderItemDTO.price)
                .build()).collect(Collectors.toList());

        return  Order.builder()
                .address(address)
                .phone(phone)
                .identity(identity)
                .items(orderItems)
                .build();
    }
}
