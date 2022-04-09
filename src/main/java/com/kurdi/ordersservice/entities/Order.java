package com.kurdi.ordersservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "orders")
public class Order {
    Integer id;
    Integer identity;
    String address;
    String phone;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    double totalCost;
    String status;
    @OneToMany(mappedBy="order")
    List<OrderItem> items = new ArrayList<>();
    public double getTotalCost() {
        totalCost = 0;
        items.forEach(item -> totalCost+= item.price * item.quantity );
        return totalCost;
    }


}
