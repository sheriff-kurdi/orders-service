package com.kurdi.ordersservice.controllers;

import com.kurdi.ordersservice.dto.OrderDTO;
import com.kurdi.ordersservice.entities.Order;
import com.kurdi.ordersservice.repositories.OrdersRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("getOrder")
    public ResponseEntity<Order> getOrder(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Integer identity = Integer.parseInt(auth.getPrincipal().toString());
        Order order = ordersRepository.findByIdentity(identity);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("getAll")
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orders = ordersRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("createOrder")
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Integer identity = Integer.parseInt(auth.getPrincipal().toString());
        Order order =  orderDTO.toOrder(identity);
        ordersRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }


}
