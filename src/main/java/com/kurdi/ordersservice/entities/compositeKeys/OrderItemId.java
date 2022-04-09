package com.kurdi.ordersservice.entities.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class OrderItemId implements Serializable {
    // CartItem can be repeated(so if it repeated add the quantity rather than create new cart item)
     Integer identity;
     String SKU;

}
