package com.kurdi.ordersservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kurdi.ordersservice.entities.compositeKeys.OrderItemId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
@ToString
public class OrderItem implements Serializable {

    @EmbeddedId
    OrderItemId id;
    int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    @JsonIgnore
    Order order;
    double price;
}

