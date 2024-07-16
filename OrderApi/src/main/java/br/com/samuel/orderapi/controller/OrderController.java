package br.com.samuel.orderapi.controller;

import br.com.samuel.orderapi.domain.Order;
import br.com.samuel.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/create-order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = service.create(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
