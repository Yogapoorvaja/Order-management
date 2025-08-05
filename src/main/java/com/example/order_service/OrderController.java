package com.example.order_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Order> createOrder(
            @RequestPart Order order,
            @RequestPart MultipartFile invoiceFile) {
        try {
            Order createdOrder = orderService.createOrder(order, invoiceFile);
            return ResponseEntity.ok(createdOrder);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Order order = orderService.getOrderById(id);
        return order != null ? 
            ResponseEntity.ok(order) : 
            ResponseEntity.notFound().build();
    }
}